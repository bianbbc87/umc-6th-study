package umc.study.Ateam.apiPayload.exception.handler;

import umc.study.Ateam.apiPayload.code.BaseErrorCode;
import umc.study.Ateam.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}