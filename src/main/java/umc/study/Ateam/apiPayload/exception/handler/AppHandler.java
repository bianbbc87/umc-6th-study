package umc.study.Ateam.apiPayload.exception.handler;

import umc.study.Ateam.apiPayload.code.BaseErrorCode;
import umc.study.Ateam.apiPayload.exception.GeneralException;

public class AppHandler extends GeneralException {
    public AppHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}