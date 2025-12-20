package br.com.dio.ui.custom.input;

import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.Font;

public class NumberText extends JTextField {

    public NumberText() {
        super();
        configure();
    }

    private void configure() {
        setHorizontalAlignment(JTextField.CENTER);
        setFont(new Font("Arial", Font.BOLD, 22));

        ((AbstractDocument) this.getDocument()).setDocumentFilter(new DocumentFilter() {

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (isValidInput(fb.getDocument().getLength(), string)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (isValidInput(fb.getDocument().getLength() - length, text)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isValidInput(int currentLength, String text) {
                if (text == null || text.isEmpty()) {
                    return true;
                }
                if (currentLength >= 1) {
                    return false;
                }
                return text.matches("[1-9]");
            }
        });
    }
}
