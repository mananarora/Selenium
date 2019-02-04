package swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import selenium.AutomatedTasks;

public class LoginForm {

	Display display = new Display();
	Shell shell = new Shell(display);
	Label user, pass, clientId;
	Text username;
	Text password;
	Text client;
	Text text;

	public LoginForm() {
		shell.setLayout(new GridLayout(2, false));
		shell.setText("Login form");
		user = new Label(shell, SWT.NULL);
		user.setText("User Name: ");

		username = new Text(shell, SWT.SINGLE | SWT.BORDER);
		username.setText("");

		pass = new Label(shell, SWT.NULL);
		pass.setText("Password: ");

		password = new Text(shell, SWT.SINGLE | SWT.BORDER);
		password.setEchoChar('*');
		password.setTextLimit(30);

		clientId = new Label(shell, SWT.NULL);
		clientId.setText("Client mnemonic: ");
		
		client = new Text(shell, SWT.SINGLE | SWT.BORDER);
		client.setText("");
		
		Button button = new Button(shell, SWT.PUSH);
		button.setText("Submit");
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (username.getText() == "") {
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
					messageBox.setMessage("Enter the User Name");
					messageBox.open();
				}
				if (password.getText() == "") {
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
					messageBox.setMessage("Enter the client mnemonic");
					messageBox.open();
				}
				if (client.getText() == "") {
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
					messageBox.setMessage("Enter the Password");
					messageBox.open();
				} else {
					AutomatedTasks at = new AutomatedTasks(username.getText(), password.getText(), client.getText());
					at.getReport();
				}
			}
		});
		username.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		password.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		client.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//shell.pack();
		shell.setSize(600, 250);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	public static void main(String[] args) {
		new LoginForm();
	}
}
