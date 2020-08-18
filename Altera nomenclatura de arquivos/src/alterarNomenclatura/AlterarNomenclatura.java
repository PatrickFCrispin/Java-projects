package alterarNomenclatura;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlterarNomenclatura extends JFrame{
	
	ActionListener alterar;
	ActionListener sair;
		
	public AlterarNomenclatura(){	
		super("Alterar nomenclatura de arquivos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,200);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 200));
		panel.setLayout(null);	//colocamos layout null para inserir os componentes abaixo.	
		
		JLabel labelDir = new JLabel("Diretório: ");
		labelDir.setBounds(140, 40, 100, 20);
		
		JTextField dir = new JTextField();
		dir.setBounds(140, 60, 200, 20);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(140, 80, 100, 30);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(240, 80, 100, 30);
		
		panel.add(labelDir);
		panel.add(dir);
		panel.add(btnAlterar);
		panel.add(btnSair);
		add(panel);
		
		alterar = new ActionListener() {	
			int j = 1;
			int cont = 0;
			String diretorio;
			File fDiretorio;
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				if(dir.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Nenhum diretório informado!");
				} else {
					diretorio = dir.getText();
					fDiretorio = new File(diretorio);
					System.out.println("Diretório: " + fDiretorio);
					
					if (fDiretorio.isDirectory()) {
						for (File file : fDiretorio.listFiles()) {
							cont++;
						}
						System.out.println("Quantidade de arquivos encontrados: " + cont);
						
						if (cont > 0) {
							for (File file : fDiretorio.listFiles()) {
								file.renameTo(new File(fDiretorio, j + "-" + file.getName()));
								j++;
							}
							JOptionPane.showMessageDialog(null, "Nomenclatura do(s) arquivo(s) alterada!");
						} else {
							JOptionPane.showMessageDialog(null, "Nenhum arquivo encontrado!");
						}
					} else{
						JOptionPane.showMessageDialog(null, "Diretório não encontrado!");
					}
				}
				dir.setText("");
				cont = 0;
				j = 1;
			}
		};
		
		sair = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Programa encerrado.");
				System.exit(0);
			}
		};
		
		btnAlterar.addActionListener(alterar);
		btnSair.addActionListener(sair);
	}
}
