package com.dc.framework.util;

public class ExpUtil {

    /**
     * 构造异常堆栈信息
     * @param ex
     * @return
     */
    public static String buildErrorMessage(Exception ex) {
        String stackTrace = getStackTraceString(ex);
        String exceptionType = ex.toString();
        String exceptionMessage = ex.getMessage();
        return String.format("%s : %s \r\n %s", exceptionType, exceptionMessage, stackTrace);
    }

    /**
     * 打印异常堆栈信息
     * @param ex
     * @return
     */
    public static String getStackTraceString(Throwable ex){
        StackTraceElement[] traceElements = ex.getStackTrace();
        StringBuilder traceBuilder = new StringBuilder();
        if (traceElements != null && traceElements.length > 0) {
            for (StackTraceElement traceElement : traceElements) {
                traceBuilder.append(traceElement.toString());
                traceBuilder.append("\n");
            }
        }
        return traceBuilder.toString();
    }

}
