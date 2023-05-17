import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.Login;
import model.Register;
import view.LoginView;
import view.RegisterView;

public class Main {
    public static void main(String[] args) {
        Register registerModel = new Register();
        try {
            // Use the platform look and feel for better integration
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RegisterView registerView = new RegisterView(registerModel);
                registerView.setVisible(true);
            }
        });
    }
}


// Login code
// Login loginModel = new Login();
//         try {
//             // Use the platform look and feel for better integration
//             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
    
//         SwingUtilities.invokeLater(new Runnable() {
//             public void run() {
//                 LoginView loginView = new LoginView(loginModel);
//                 loginView.setVisible(true);
//             }
//         });

// Register registerModel = new Register();
//         try {
//             // Use the platform look and feel for better integration
//             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
    
//         SwingUtilities.invokeLater(new Runnable() {
//             public void run() {
//                 RegisterView registerView = new RegisterView(registerModel);
//                 registerView.setVisible(true);
//             }
//         });