package lin.kot.lat.myapplication.view.upload.type

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Spinner
import lin.kot.lat.myapplication.R

class PeopleWanted : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.people_wanted_type)

        val spinner = findViewById(R.id.spinner) as Spinner
// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.SpinnerFor, android.R.layout.simple_spinner_item
        )
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
// Apply the adapter to the spinner
        spinner.adapter = adapter

    }
}
