package kg.tutorialapp.homework_44

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    private var myList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()

    }

    private fun setup() {

        recyclerView = findViewById(R.id.recyclerView)
        val add = findViewById<Button>(R.id.btn_add_item)
        val editText = findViewById<EditText>(R.id.editText)

        adapter = MyAdapter(myList, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        add.setOnClickListener {
            if (editText.text.toString().isEmpty())
                myList.remove(editText.text.toString())
            else{
                myList.add(editText.text.toString())
                adapter.notifyDataSetChanged()
            }
        }
    }
    override fun onItemClick(index: Int) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Item deletion")
        dialog.setMessage("Do you want to delete this item?")
        dialog.setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
            adapter.deleteItem(index)
        })
        dialog.setNegativeButton("No", DialogInterface.OnClickListener { _, _ ->
        })
        dialog.show()
    }


}