package Controller;

 
 
import ConnectBean.ConnectionProvider;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.http.Cookie;
import Fun.MaHoaDuLieu;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


@Named(value = "loginManagerBean")
@SessionScoped
public class LoginManagerBean implements Serializable {

    
   
    
    private String username;
    private String password;
 
 

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    private String msg;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //validate login
    public String validateusernamepassword() throws IOException, NoSuchAlgorithmException {
        
        boolean valid=false;
        String[] dspram=null;
        
	String mahoapass=MaHoaDuLieu.md5hash(username+password);
     //Kiem tra cookie xem co gia tri chua , neu chua se gan moi .
        // CookieHelper cookieHelper= new CookieHelper();
        // cookieHelper.setCookie(username, "", 0);
        //cookieHelper.setCookie(username+"-"+"info", "", 0);
       // Cookie cookie=cookieHelper.getCookie(username);
          valid = true;
      /*  if (cookie == null){
            valid = true; //LoginDao.validate(username, password);
         //   cookieHelper.setCookie(username, mahoapass, 20*60);
        }
        else{
            String kqcokie = cookie.getValue();
            if (mahoapass.equalsIgnoreCase(kqcokie)) {
                valid = true;
            } else {

                valid = false;
            }
 
        }
*/
 
        try {
            if (valid) {
                 // Ket noi database.
                Connection con = null;
                ConnectionProvider provider=new ConnectionProvider();
               // ConnectionProvider.reconnectdbastatic();
          //      UserModel useMD = new UserModel();
               //  Connection con = null;
           /*     con = provider.getCon();
                HttpSession session = SessionBean.getSession();
                String sessionid = session.getId();
                Cookie cookieinfor=cookieHelper.getCookie(username+"-"+"info"); 
                 if (cookieinfor != null){
                    String kqencode= cookieinfor.getValue();
                    byte [] barr = Base64.getDecoder().decode(kqencode);
                    String kqdecode=new String(barr);
                    dspram=kqdecode.split("@");
               
                 }
               
                 
                useMD.setUserid(username.toString());
                useMD.setUsername(dspram[2]);
                useMD.setHomebranch(dspram[1]);
                
                session.setAttribute("g_tenht", sessionid);
                session.setAttribute("g_userid", useMD);
                session.setAttribute("g_id_chinhanh",dspram[1] );
 
                // Thêm cookie
 */
         
                return "index";

            } else {
              //  SystemFunc.SystemBean.proMessError("Lỗi đăng nhập");
                return null;
            }
        }
        
        catch (Exception e) {
                // SystemFunc.SystemBean.proMessError(e.getMessage());
            return null;
        }
    }
 

    public String logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        return "login" + "?faces-redirect=true";
    }

    public LoginManagerBean() {
    }

}
