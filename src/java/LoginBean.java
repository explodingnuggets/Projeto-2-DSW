import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

    public LoginBean() {
      System.out.println("LoginBean started!");   
   }
    
    public String login() {

        return "faces/index";
    }
}