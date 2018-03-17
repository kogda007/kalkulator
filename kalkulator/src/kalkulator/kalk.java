package kalkulator;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class kalk {

	protected Shell shell;
	private Text firstText;
	private Text Secondtext;

	/**
	 * Launch the application.
	 * @param args kooasdasdasda
	 */
	public static void main(String[] args)  {
		try {
			kalk window = new kalk();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("M鎩 pierwszy kalkulator w JAVA");
		
		firstText = new Text(shell, SWT.BORDER);
		firstText.setBounds(26, 31, 123, 28);
		
		Secondtext = new Text(shell, SWT.BORDER);
		Secondtext.setBounds(26, 102, 123, 28);
		
		Label FirstLabel = new Label(shell, SWT.NONE);
		FirstLabel.setBounds(26, 10, 71, 15);
		FirstLabel.setText("First number");
		
		Label SecondLabel = new Label(shell, SWT.NONE);
		SecondLabel.setBounds(26, 81, 123, 15);
		SecondLabel.setText("Second number");
		
		final Label AnswerLabel = new Label(shell, SWT.NONE);
		AnswerLabel.setFont(SWTResourceManager.getFont("Pristina", 26, SWT.BOLD));
		AnswerLabel.setBounds(26, 173, 264, 67);
		AnswerLabel.setText("Wynik:");
		
		Button PlusButton = new Button(shell, SWT.NONE);
		PlusButton.setToolTipText("add");
		PlusButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int number1, number2;
			
				try {
					number1 = Integer.parseInt(firstText.getText());
				}
				catch (Exception exc) 
				{
					MessageDialog.openError(shell, "B章d", "Nieprawid這wa wartosc w pierwszej liczbie!");
					return; 
				}
				
				try {
					number2 = Integer.parseInt(Secondtext.getText());
				}
					catch (Exception exc) 
				{
						MessageDialog.openError(shell, "B章d", "Nieprawid這wa wartosc w drugiej liczbie!");
						return;
					}
				int answer = number1 + number2;
				AnswerLabel.setText("Wynik:" + answer);
				}
				
			}
			
		);
		
		PlusButton.setBounds(212, 52, 75, 25);
		PlusButton.setText("+");
		
		
		
		Button MinusButton = new Button(shell, SWT.NONE);
		MinusButton.setToolTipText("substract");
		MinusButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int number1, number2;
				
				try {
					number1 = Integer.parseInt(firstText.getText());
				}
					catch (Exception exc) 
				{
						MessageDialog.openError(shell, "B章d", "Nieprawid這wa wartosc w pierwszej liczbie!");
						return;
					}
				
				try {
					number2 = Integer.parseInt(Secondtext.getText());
				}
					catch (Exception exc) 
				{
						MessageDialog.openError(shell, "Blad", "Nieprawid這wa wartosc w drugiej liczbie!");
						return;
					}
				int answer = number1 - number2;
				AnswerLabel.setText("Wynik to: " + answer);
			}
		});
		MinusButton.setBounds(336, 52, 75, 25);
		MinusButton.setText("-");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Goudy Old Style", 14, SWT.BOLD));
		lblNewLabel.setBounds(237, 10, 156, 36);
		lblNewLabel.setText("OPERATIONS:");
		
		Button MultiplyButton = new Button(shell, SWT.NONE);
		MultiplyButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int number1, number2;
				
				try {
					number1 = Integer.parseInt(firstText.getText());
				}
				catch (Exception exc) 
				{
					MessageDialog.openError(shell, "B章d", "Nieprawid這wa wartosc w pierwszej liczbie!");
					return; 
				}
				
				try {
					number2 = Integer.parseInt(Secondtext.getText());
				}
					catch (Exception exc) 
				{
						MessageDialog.openError(shell, "B章d", "Nieprawid這wa wartosc w drugiej liczbie!");
						return;
					}
				int answer = number1 * number2;
				AnswerLabel.setText("Wynik:" + answer);
				
			}
		});
		MultiplyButton.setToolTipText("multiply");
		MultiplyButton.setBounds(212, 117, 78, 25);
		MultiplyButton.setText("*");
		
		Button DivisionButton = new Button(shell, SWT.NONE);
		DivisionButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) throws ArithmeticException {
				
				int number1, number2;
				
				 {
					number1 = Integer.parseInt(firstText.getText());
					if(number1 == 0)
						throw new ArithmeticException("Nie mozna dzieli?przez 0");
				}
				
				
				try {
					number2 = Integer.parseInt(Secondtext.getText());
					if(number2 == 0)
						throw new ArithmeticException("Nie mozna dzieli?przez 0");
				}
					catch (Exception exc) 
				{
						MessageDialog.openError(shell, "B章d", "Nieprawid這wa wartosc w drugiej liczbie!");
						return;
					}
				int answer = number1 / number2;
				AnswerLabel.setText("Wynik:" + answer);
				}
			
		});
		DivisionButton.setToolTipText("division");
		DivisionButton.setBounds(336, 117, 75, 25);
		DivisionButton.setText("/");

	}
}
