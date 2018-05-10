package coconversa;

import clientes.ClienteHiloEscritura;
import datos.Usuario;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FormCrearGrupo extends JFrame implements ActionListener
{
    
    private JLabel lblCrearGrupo;
    private JTextField txtNombreGrupo;
    private JPanel pnlListaAmigos;
    private JScrollPane scrListaAmigos;
    private JButton btnCrearGrupo;
    
    private List <Usuario> usuariosGeneral; //Lista para traer a los usuarios

    public FormCrearGrupo(List <Usuario> usuarios)
    {
       this.usuariosGeneral = usuarios;
        configurar();
        componentes();
    }
    
    public void configurar()
    {
        this.setTitle("Crear Grupo");
        this.setSize(300,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void componentes()
    {
        lblCrearGrupo = new JLabel("Crear Grupo");
        lblCrearGrupo.setFont(new Font("Calibri (Cuerpo)", Font.BOLD, 18));
        
        txtNombreGrupo = new JTextField("//Nombre de Grupo//");
        
        pnlListaAmigos = new JPanel();
        pnlListaAmigos.setLayout(new BoxLayout(pnlListaAmigos,Y_AXIS));
        
        scrListaAmigos = new JScrollPane(pnlListaAmigos);
        scrListaAmigos.getVerticalScrollBar().setUnitIncrement(10);
        scrListaAmigos.setPreferredSize(new Dimension(250,250));
        scrListaAmigos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrListaAmigos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        btnCrearGrupo = new JButton("Crear Grupo");
        btnCrearGrupo.addActionListener(this);
        //public piña
       
        
        //
        pnlListaAmigos.add(Box.createVerticalStrut(10));
        for(int i=0; i<usuariosGeneral.size(); i++)
        {
            
            JCheckBox amigo = new JCheckBox(usuariosGeneral.get(i).getNombre());
            amigo.setAlignmentX(Component.CENTER_ALIGNMENT);
            pnlListaAmigos.add(amigo);
            pnlListaAmigos.add(Box.createVerticalStrut(10));
        }
        
        GroupLayout contentPane = new GroupLayout(this.getContentPane());
        contentPane.setAutoCreateContainerGaps(true);
        contentPane.setAutoCreateGaps(true);
        contentPane.setHorizontalGroup
        (
            contentPane.createParallelGroup(CENTER)
                .addComponent(lblCrearGrupo)
                .addComponent(txtNombreGrupo)
                .addComponent(scrListaAmigos)
                .addComponent(btnCrearGrupo)
        );
        contentPane.setVerticalGroup
        (
            contentPane.createSequentialGroup()
                .addComponent(lblCrearGrupo)
                .addComponent(txtNombreGrupo,30,30,30)
                .addComponent(scrListaAmigos)
                .addComponent(btnCrearGrupo)
        );
        this.setLayout(contentPane);
        this.pack();
    }
            
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==btnCrearGrupo)   
        { 
         ClienteHiloEscritura crearGrupo = new ClienteHiloEscritura();  
         crearGrupo.crearGrupo(txtNombreGrupo.getText(), usuariosGeneral);
        }
    }
}