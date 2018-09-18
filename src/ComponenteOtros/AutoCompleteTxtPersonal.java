/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteOtros;

import AlmacenClases.Personal;
import AlmacenPresentacion.FrmGrupos_Personal;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer.Form;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author jsarango
 */
public abstract class AutoCompleteTxtPersonal{
    
    public AutoCompleteTxtPersonal(){
    }
    
    private static boolean isAdjusting(JComboBox cbInput) {
        if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
            return (Boolean) cbInput.getClientProperty("is_adjusting");
        }
        return false;
    }

    private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
        cbInput.putClientProperty("is_adjusting", adjusting);
    }

    public static ImageIcon getImageIcon(String url, Map<String, ImageIcon> IMAGE_ICON_CACHE) {
        if (url == null) {
            return null;
        }
        if (IMAGE_ICON_CACHE.get(url) == null) {
            ImageIcon image = null;
            InputStream in = FrmGrupos_Personal.class.getResourceAsStream(url);
            if (in != null) {
                try {
                    byte buffer[] = new byte[in.available()];
                    for (int i = 0, n = in.available(); i < n; i++) {
                        buffer[i] = (byte) in.read();
                    }
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Image img = toolkit.createImage(buffer);
                    image = new ImageIcon(img);
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
            if (image == null) {
                if (ClassLoader.getSystemResource(url) != null) {
                    image = new ImageIcon(ClassLoader.getSystemResource(url));
                } else {
                    image = new ImageIcon(url);
                }
            }
            if (image == null) {
                System.err.println("can't load image '" + url + "'");
            } else {
                IMAGE_ICON_CACHE.put(url, image);
            }
        }
        return (ImageIcon) IMAGE_ICON_CACHE.get(url);
    }


    static void AutoCompleteTxtPersonal1(final JTextField txtInput, final List<Personal> items) {
        
        final DefaultComboBoxModel model = new DefaultComboBoxModel();
        final Map<String, ImageIcon> IMAGE_ICON_CACHE = new HashMap<String, ImageIcon>();

        final JComboBox cbInput = new JComboBox(model) {
            public Dimension getPreferredSize() {
                return new Dimension(super.getPreferredSize().width, 0);
            }
        };

        setAdjusting(cbInput, false);

        for (Personal item : items) {
            model.addElement(item.getApellidos());
        }
        cbInput.setSelectedItem(null);

        cbInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isAdjusting(cbInput)) {
                    if (cbInput.getSelectedItem() != null) {
                        txtInput.setText(cbInput.getSelectedItem().toString());
                    }
                }
            }
        });

        cbInput.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value != null) {
                    this.setText(value.toString());
                    String url = value.toString().replaceAll(" ", "_") + ".png";
                    ImageIcon icon = getImageIcon(url, IMAGE_ICON_CACHE);
                    if (icon != null) {
                        this.setIcon(icon);
                    }
                }
                return this;
            }
        });

        txtInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                setAdjusting(cbInput, true);
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (cbInput.isPopupVisible()) {
                        e.setKeyCode(KeyEvent.VK_ENTER);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    e.setSource(cbInput);
                    cbInput.dispatchEvent(e);
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        txtInput.setText(cbInput.getSelectedItem().toString());
                        
                        
                        cbInput.setPopupVisible(false);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    cbInput.setPopupVisible(false);
                }
                setAdjusting(cbInput, false);
            }
        });

        txtInput.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateList();
            }

            public void removeUpdate(DocumentEvent e) {
                updateList();
            }

            public void changedUpdate(DocumentEvent e) {
                updateList();
            }

            private void updateList() {
                setAdjusting(cbInput, true);
                model.removeAllElements();
                String input = txtInput.getText();
                if (!input.isEmpty()) {
                    for (Personal item : items) {
                        if (item.getApellidos().toLowerCase().startsWith(input.toLowerCase())) {
                            model.addElement(item.getApellidos()+","+item.getNombres()+"-"+item.getDNI());
                        }
                    }
                }
                cbInput.hidePopup();
                cbInput.setPopupVisible(model.getSize() > 0);
                setAdjusting(cbInput, false);
            }
        });


        txtInput.setLayout(new BorderLayout());
        txtInput.add(cbInput, BorderLayout.SOUTH);
    }
}
