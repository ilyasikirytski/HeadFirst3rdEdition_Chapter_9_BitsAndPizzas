package com.example.chapter_9_bitsandpizzas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.chapter_9_bitsandpizzas.databinding.FragmentOrderBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {

    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root


        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {

            val pizzaType = binding.pizzaGroup.checkedRadioButtonId


            if (pizzaType == -1) {
                Snackbar.make(binding.fab, "Please choose pizza type!", Snackbar.LENGTH_SHORT)
                    .setAction("Check Diavolo") {
                        binding.pizzaGroup.check(R.id.radio_diavolo)
                    }.setAnchorView(binding.fab).show()
            } else {
                var text = (when (pizzaType) {
                    R.id.radio_diavolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                })
                if (binding.parmesan.isChecked) {
                    text += ", Parmezan"
                }
                if (binding.chiliOil.isChecked) {
                    text += ", Chili Oil"
                }

                Snackbar.make(binding.fab, "Your order: $text", Snackbar.LENGTH_SHORT)
                    .setAction("Confirm") {
                        Toast.makeText(context, "Confirmed!", Toast.LENGTH_SHORT).show()
                    }.setAnchorView(binding.fab).show()
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}