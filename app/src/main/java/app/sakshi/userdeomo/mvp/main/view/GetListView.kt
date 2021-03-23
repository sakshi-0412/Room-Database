package app.sakshi.userdeomo.mvp.main.view

import app.sakshi.userdeomo.mvp.main.model.list.resposne.ListResponse

interface GetListView {

    fun onLisSuccess(form: ListResponse)
    fun onLisFailure(failureMsg: String?)
}