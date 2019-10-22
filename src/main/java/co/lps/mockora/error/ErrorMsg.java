package co.lps.mockora.error;

public final class ErrorMsg {

  private ErrorMsg() {}

  public static final String LOG_MOCK_NOT_FOUND = "No mock Api for %s/%s found";

  public static final String LOG_REQUEST_METHOD_NOT_FOUND = "%s Request Method not supported";
}
