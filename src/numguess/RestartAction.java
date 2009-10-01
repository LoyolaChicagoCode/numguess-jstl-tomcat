package numguess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 * This action is invoked when the game is restarted.
 */
public class RestartAction extends Action implements Constants {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
	  
	  	// obtain arguments from form bean
		DynaActionForm rangeForm = (DynaActionForm) form;
		int min = ((Integer) rangeForm.get("min")).intValue();
		int max = ((Integer) rangeForm.get("max")).intValue();
		
		// interact with model
		HttpSession session = request.getSession();
		UserData model = (UserData) session.getAttribute(ATTRIBUTE_USERDATA);
		model.reset(min, max);
		
		// choose forwarding target
		return mapping.findForward(FORWARD_RESTART);
	}
}