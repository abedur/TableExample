package com.miu.table

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout

import android.widget.TableRow
import android.widget.TextView
import com.miu.table.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var tableLayout:TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)


        tableLayout = binding.tblLayout

        binding.addBtn.setOnClickListener {
            val version = binding.version.text.toString();
            val code = binding.code.text.toString();

            if(binding.version.text.trim().isNullOrEmpty()){
                binding.version.error = "Version must be enter.";
            }else if(binding.code.text.trim().isNullOrEmpty()){
                binding.code.error = "Code must be entered."
            }
            else{
                val tableRow = TableRow(this);
                val versionTextView = TextView(this);
                versionTextView.text = version;
                val codeTextView = TextView(this);
                codeTextView.text = code;

                tableRow.addView(versionTextView);
                tableRow.addView(codeTextView);
                tableLayout.addView(tableRow);
                binding.version.text.clear();
                binding.code.text.clear();
            }
        }
    }

}