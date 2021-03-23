package app.sakshi.userdeomo.mvp.main.view

import app.sakshi.userdeomo.mvp.main.model.form.resposne.FormResponse


interface AddFormView {
    fun onAddFormSuccess(form: FormResponse)
    fun onAddFormFailure(failureMsg: String?)
}