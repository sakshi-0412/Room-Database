package app.sakshi.userdeomo.mvp.main.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import app.sakshi.userdeomo.R
import app.sakshi.userdeomo.mvp.main.listener.OnItemClickListener
import app.sakshi.userdeomo.mvp.main.model.form.resposne.FormResponse
import app.sakshi.userdeomo.mvp.main.presenter.AddFormPresenter
import app.sakshi.userdeomo.mvp.main.view.AddFormView
import app.sakshi.userdeomo.utils.Common
import app.sakshi.userdeomo.utils.SharedPreferenceManager
import java.text.SimpleDateFormat
import java.util.*


class AddFormFragment : Fragment(), AddFormView, OnItemClickListener {
    private val TAG = javaClass.simpleName
    private var moRootView: View? = null
    private lateinit var edAmount: EditText
    private lateinit var edDate: EditText
    private lateinit var edDrHead: EditText
    private lateinit var edCrHead: EditText
    private lateinit var edPaymentMode: EditText
    private lateinit var btnUpload: Button
    private lateinit var btSave: Button
    private lateinit var sharedPreferenceManager: SharedPreferenceManager

    private var addFormPresenter: AddFormPresenter? = null

    private var selectedDate = ""
    private var status = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moRootView = inflater.inflate(R.layout.fragment_add_form, container, false)

        sharedPreferenceManager = SharedPreferenceManager(context)
        addFormPresenter = AddFormPresenter(context!!, this)
        status = sharedPreferenceManager.status
        return moRootView

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edAmount = moRootView!!.findViewById(R.id.edAmount)
        edDate = moRootView!!.findViewById(R.id.edDate)
        edDrHead = moRootView!!.findViewById(R.id.edDrHead)
        edCrHead = moRootView!!.findViewById(R.id.edCrHead)
        edPaymentMode = moRootView!!.findViewById(R.id.edPaymentMode)
        btnUpload = moRootView!!.findViewById(R.id.btnUpload)
        btSave = moRootView!!.findViewById(R.id.btSave)

        selectDate()

        btSave.setOnClickListener {
            if (Common.isInternetAvailable(context)) {
                addForm()
            } else {
            }
        }

    }


    private fun selectDate() {

        edDate.setOnClickListener {
            val sdf = SimpleDateFormat("DD-MM-yyyy")
            val parse: Date = sdf.parse(edDate.text.toString())

            val loCalender = Calendar.getInstance()
            loCalender.time = parse
            val loYear = loCalender.get(Calendar.YEAR)
            var loMonth = loCalender.get(Calendar.MONTH)
            val loDay = loCalender.get(Calendar.DAY_OF_MONTH)

            //loMonth += 1

            val loDatePicker = context?.let { view ->
                DatePickerDialog(
                    view,
                    DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                        val loMonth1 = monthOfYear + 1
                        var loMonthFinal = loMonth1.toString()
                        var loDay: String = dayOfMonth.toString()
                        if (loMonth1 < 10) {
                            loMonthFinal = "0" + loMonthFinal
                        }

                        if (dayOfMonth < 10) {
                            loDay = "0" + dayOfMonth
                        }

                        // edDate.text = "$loDay-$loMonthFinal-$year"
                        selectedDate = "$loDay-$loMonthFinal-$year"
                    },
                    loYear,
                    loMonth,
                    loDay
                )
            }

            loDatePicker?.show()
        }


    }

    private fun addForm() {
        addFormPresenter!!.addForm(
            0,
            "CrcptG",
            1039,
            0,
            100,
            selectedDate,
            status, //todo change according to selected item
            584,
            918,
            1503,
            993,
            "",
            993,
            "",
            "",
            "",
            ""
        )
    }


    override fun onAddFormSuccess(form: FormResponse) {
        Log.e(TAG, " onAddFormSuccess: \t status \t $form")
        val error = form.stError
        if (error == 200) {
            Toast.makeText(context, "" + form.stMessage, Toast.LENGTH_LONG).show()
        }

    }

    override fun onAddFormFailure(failureMsg: String?) {
        Log.e(TAG, " onAddFormFailure: \t failureMsg \t $failureMsg")
    }

    override fun onItemClick(position: Int, status: String) {
    }

}