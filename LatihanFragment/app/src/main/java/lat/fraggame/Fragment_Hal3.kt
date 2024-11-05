package lat.fraggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.bottomnavigation.BottomNavigationView


// TODO: Rename parameter arguments, choose names that match

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_Hal3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_Hal3 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment__hal3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val _startNumberInput = view.findViewById<EditText>(R.id.startNumberInput)
        val _btnStartGane = view.findViewById<Button>(R.id.btnStartGame)

        _btnStartGane.setOnClickListener {
            val mfHalaman1 = Fragment_Hal1()
            val mFragmentManager = parentFragmentManager

            val nextStartNumber = if (_startNumberInput.text.isNotEmpty()) {
                _startNumberInput.text.toString().toInt()
            } else {
                1
            }
            Fragment_Hal1.startNumber = nextStartNumber

            val MainBotNav =
                (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottomNav)
            MainBotNav.selectedItemId = R.id.game_menu
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_Hal3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Hal3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}