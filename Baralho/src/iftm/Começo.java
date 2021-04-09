package iftm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Começo extends JFrame{

	private JLabel title, j1, j2, img;
	public String nomej1, nomej2;
	public JTextField txtJ1, txtJ2;
	private JButton btn, cadastrar1, cadastrar2;
	public ArrayList<Jogador1> jogador1 = new ArrayList<Jogador1>();
	public ArrayList<Jogador2> jogador2 = new ArrayList<Jogador2>();
	String[] naipe = {"♦", "♥", "♠", "♣"};
	String[] cartas = {"A", "2", "3" , "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	String[] valorCartas = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "10", "10", "10"};
	int[] intvalorCartas = new int[valorCartas.length];
	public ArrayList<Card> baralho = new ArrayList<Card>();
	
	public Começo(){
		
		this.setSize(500, 400);
		this.setTitle("Jogo de Cartas");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		criaComponentes();
		criaAcoes();
		
		this.setVisible(true);
	}
	
	private void criaComponentes(){
		
		ImageIcon imagem = new ImageIcon("imagem/tamanduaSoftwares.jpg");
		img = new JLabel(imagem);
		img.setFont(new Font("Tahoma", Font.PLAIN, 40));
		img.setBounds(1, 1, 490, 300);
		add(img);
		
		
		title = new JLabel("JOGO DE BARALHO:  21");
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setBounds(140, 20, 220, 25);
		add(title);
		
		j1 = new JLabel("Nome - Jogador 1");
		j1.setBounds(30, 100, 100, 25);
		add(j1);
		
		txtJ1 = new JTextField();
		txtJ1.setBounds(30, 120, 100, 25);
		add(txtJ1);
		
		j2 = new JLabel("Nome - Jogador 2");
		j2.setBounds(360, 100, 100, 25);
		add(j2);
		
		txtJ2 = new JTextField();
		txtJ2.setBounds(360, 120, 100, 25);
		add(txtJ2);
		
		cadastrar1 = new JButton("Cadastrar");
		cadastrar1.setBounds(30, 150, 100, 25);
		add(cadastrar1);
		
		cadastrar2 = new JButton("Cadastrar");
		cadastrar2.setBounds(360, 150, 100, 25);
		add(cadastrar2);
		
		btn = new JButton("Começar");
		btn.setBounds(195, 250, 100, 25);
		add(btn);
		
		
		
	}
	
	private void criaAcoes(){
		
		cadastrar1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nomej1 = txtJ1.getText();
				Jogador1 j1 = new Jogador1(nomej1);
				jogador1.add(j1);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		
		cadastrar2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nomej2 = txtJ2.getText();
				Jogador2 j2 = new Jogador2(nomej2);
				jogador2.add(j2);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}
		});
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int valorArray = baralho.size();
				Cartas carta = new Cartas(Começo.this, nomej1, nomej2, valorArray);
				Começo.this.setVisible(false);
				
			}
		});
	}
	
	
	public void preencherBaralho(){
		
		
		for(int k = 0; k < intvalorCartas.length; k++){
			intvalorCartas[k] = Integer.parseInt(valorCartas[k]);
			
		}
		
		for(int i = 0; i < cartas.length; i ++){
			for(int j = 0; j < naipe.length; j++){
				Card cards = new Card(cartas[i], naipe[j], intvalorCartas[i]);
				baralho.add(cards);
				
			}
		}
		
		Collections.shuffle(baralho);
		
		
	}
	
	
	
	
}
