package app.sakshi.userdeomo.mvp.main.view

import app.sakshi.userdeomo.mvp.main.model.status.resposne.StatusResponse

interface StatusView {
    fun onStatusSuccess(status: StatusResponse)
    fun onStatusFailure(failureMsg: String?)
}