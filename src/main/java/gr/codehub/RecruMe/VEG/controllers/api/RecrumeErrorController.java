package gr.codehub.RecruMe.VEG.controllers.api;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * RecrumeErrorController used to ensure software quality, so that the end-user will not see default error pages,
 * but rather the proper pre-defined HTTP code per call.
 */

@RestController
public class RecrumeErrorController implements ErrorController {

    /**
     * Display specific HTTP code for errors
     * @param request
     * @return the proper HTTP code message per call
     */

    @RequestMapping("error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

        if (statusCode == 400)
            return "Bad Request";

        if (statusCode == 401)
            return "Unauthorized";

        if (statusCode == 403)
            return "Forbidden";

        if (statusCode == 404)
            return "Not Found";

        if (statusCode == 500)
            return "Internal Server Error";


        return String.format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
                        + "<div>Exception Message: <b>%s</b></div><body></html>",
                statusCode, exception == null ? "N/A" : exception.getMessage());

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
