package uts.c14220233.latfraggame

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSatu.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSatu : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_satu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        MainActivity.playerScore.score = 50
        val _tvCurrentScore = view.findViewById<TextView>(R.id.tvCurrentScore)
        _tvCurrentScore.setText(MainActivity.playerScore.score.toString())


        val _btnA = view.findViewById<Button>(R.id.btnA)
        val _btnB = view.findViewById<Button>(R.id.btnB)
        val _btnC = view.findViewById<Button>(R.id.btnC)
        val _btnD = view.findViewById<Button>(R.id.btnD)
        val _btnE = view.findViewById<Button>(R.id.btnE)
        val _btnF = view.findViewById<Button>(R.id.btnF)
        val _btnG = view.findViewById<Button>(R.id.btnG)
        val _btnH = view.findViewById<Button>(R.id.btnH)
        val _btnI = view.findViewById<Button>(R.id.btnI)
        val _btnJ = view.findViewById<Button>(R.id.btnJ)

        val btnArray = arrayOf(_btnA, _btnB, _btnC, _btnD, _btnE, _btnF, _btnG, _btnH, _btnI, _btnJ)
        btnArray.shuffle()


        var cardNumber = startNumber
        for (i in btnArray.indices step 2) {
            btnArray[i].setText(cardNumber.toString())
            if (i + 1 < btnArray.size) {
                btnArray[i + 1].setText(cardNumber.toString())
            }
            cardNumber++
        }


        var opened1: Button? = null
        var opened2: Button? = null

        var matchedPairs = 0;
        var totalPairs = btnArray.size / 2;

        for (button in btnArray) {
            button.setOnClickListener {
                if (opened1 == null) {
                    opened1 = button
                    button.setText(button.text.toString())
                    button.setTextColor(Color.BLACK)
                    button.isEnabled = false
                } else if (opened2 == null) {
                    opened2 = button
                    button.setText(button.text.toString())
                    button.setTextColor(Color.BLACK)
                    button.isEnabled = false

                    var cardValue1 = opened1?.text.toString().toInt()
                    var cardValue2 = opened2?.text.toString().toInt()

                    if (cardValue1 == cardValue2) {
                        matchedPairs++
                        MainActivity.playerScore.score += 10
                        opened1?.setTextColor(Color.parseColor("#008000"))
                        opened2?.setTextColor(Color.parseColor("#008000"))
                        opened1 = null
                        opened2 = null

                        _tvCurrentScore.setText(MainActivity.playerScore.score.toString())

                        if (matchedPairs == totalPairs) {

                            val MainBotNav =
                                (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottomNav)
                            MainBotNav.selectedItemId = R.id.score_menu
                        }
                    } else {
                        opened1?.setTextColor(Color.RED)
                        opened2?.setTextColor(Color.RED)

                        MainActivity.playerScore.score -= 5
                        _tvCurrentScore.setText(MainActivity.playerScore.score.toString())

                        button.postDelayed({
                            opened1?.isEnabled = true
                            opened2?.isEnabled = true
                            opened1?.setTextColor(Color.TRANSPARENT)
                            opened2?.setTextColor(Color.TRANSPARENT)
                            opened1 = null
                            opened2 = null
                        }, 1000)
                    }
                }
            }
        }


        val _btnEnd = view.findViewById<Button>(R.id.btnEnd)
        _btnEnd.setOnClickListener {
            val MainBotNav =
                (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottomNav)
            MainBotNav.selectedItemId = R.id.score_menu
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_Hal1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSatu().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        var startNumber = 1;
    }
}