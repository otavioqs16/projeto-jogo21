package iftm;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Cartas extends JFrame{

	Começo janMeAbriu;
	
	int pont1 = 0, pont2 = 0, qtdCartas = 0, pontfalta1 = 21, pontfalta2 = 21, chanceganhar1, chanceganhar2;
	private JLabel ganhador, perdedor, j1, j2, carta1, carta2, pontj1, pontj2, limg, limg1, baralho, imgbaralho, qtd, ganhar1, ganhar2, perder1 , perder2, continuar1, continuar2;
	private JButton pegar1, pegar2, voltar, sair, parar1, parar2;
	String nomej11, nomej22;
	int valorarray;
	
	public Cartas(Começo meAbriu, String pnomej11, String pnomej22, int pvalorarray){
		
		this.setSize(500, 550);
		this.setTitle("Jogo de Cartas");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		nomej11 = pnomej11;
		nomej22 = pnomej22;
		valorarray = pvalorarray;
		criaComponentes();
		criaAcoes();
		janMeAbriu = meAbriu;
		this.setVisible(true);
		
	}
	
	private void criaComponentes(){
		
		
		
		j1 = new JLabel(nomej11);
		j1.setBounds(50, 10, 100, 25);
		add(j1);
		
		j2 = new JLabel(nomej22);
		j2.setBounds(370, 10, 100, 25);
		add(j2);
		
		baralho = new JLabel("BARALHO");
		baralho.setBounds(215, 40, 100, 25);
		add(baralho);
		
		ImageIcon imgb = new ImageIcon("imagem/cardBack_red4.png");
		imgbaralho = new JLabel(imgb);
		imgbaralho.setBounds(50, 40, 390, 270);
		add(imgbaralho);
		
		qtd = new JLabel("Quantidade de cartas: " + valorarray );
		qtd.setBounds(175, 300, 200, 25);
		add(qtd);
		
		ganhador = new JLabel("Ganhador: A ser definido");
		ganhador.setBounds(175, 360, 200, 25);
		add(ganhador);
		
		perdedor = new JLabel("Perdedor: A ser definido");
		perdedor.setBounds(175, 390, 200, 25);
		add(perdedor);
		
		pegar1 = new JButton("Comprar Carta");
		pegar1.setBounds(15, 40, 150, 25);
		add(pegar1);
		
		pontj1 = new JLabel("Pontuação: ");
		pontj1.setBounds(30, 280, 100, 25);
		add(pontj1);
		
		pegar2 = new JButton("Comprar Carta");
		pegar2.setBounds(325, 40, 150, 25);
		add(pegar2);
		
		pontj2 = new JLabel("Pontuação: ");
		pontj2.setBounds(350, 280, 100, 25);
		add(pontj2);
		
		sair = new JButton("Sair");
		sair.setBounds(260, 460, 100, 25);
		add(sair);
		
		parar1 = new JButton("Parar");
		parar1.setBounds(30, 310, 100, 25);
		add(parar1);
		
		ganhar1 = new JLabel("Ganhar: ");
		ganhar1.setBounds(30, 340, 200, 25);
		add(ganhar1);
		
		perder1 = new JLabel("Perder: ");
		perder1.setBounds(30, 370, 200, 25);
		add(perder1);
		
		continuar1 = new JLabel("Continuar: ");
		continuar1.setBounds(30, 400, 200, 25);
		add(continuar1);
		
		parar2 = new JButton("Parar");
		parar2.setBounds(350, 310, 100, 25);
		add(parar2);
		
		ganhar2 = new JLabel("Ganhar: ");
		ganhar2.setBounds(350, 340, 200, 25);
		add(ganhar2);
		
		perder2 = new JLabel("Perder: ");
		perder2.setBounds(350, 370, 200, 25);
		add(perder2);
		
		continuar2 = new JLabel("Continuar: ");
		continuar2.setBounds(350, 400, 200, 25);
		add(continuar2);
		
		carta1 = new JLabel("");
		carta1.setBounds(70, 70, 100, 25);
		add(carta1);
		
		carta2 = new JLabel("");
		carta2.setBounds(390, 70, 100, 25);
		add(carta2);
		
		voltar = new JButton("Voltar");
		voltar.setBounds(130, 460, 100, 25);
		add(voltar);
		
		limg1 = new JLabel();
		limg1.setBounds(00, 50, 200, 270);
		add(limg1);
		
		limg = new JLabel();
		limg.setBounds(300, 50, 200, 270);
		add(limg);
		
	}
	
	private void criaAcoes(){
		
		
		pegar1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				limg1.setVisible(false);
				Random rand = new Random();
				int sorteio = rand.nextInt(janMeAbriu.baralho.size());
				Cartas.this.setVisible(false);
				String carta11 = "imagem/"+janMeAbriu.baralho.get(sorteio).getCartas()+janMeAbriu.baralho.get(sorteio).getNaipe()+".png";
				ImageIcon img1 = new ImageIcon(carta11);
				limg1 = new JLabel(img1);
				limg1.setBounds(-10, 40, 200, 270);
				add(limg1);
				
				
				pont1 += janMeAbriu.baralho.get(sorteio).getValor();
				pontj1.setText("Pontuação: " + pont1);
				
				ganhar1();
				perder1();
				continuar1();
				
				
				pegar1.setEnabled(false);
				pegar2.setEnabled(true);
				janMeAbriu.baralho.remove(sorteio);
				qtd.setText("Quantidade de cartas: " + janMeAbriu.baralho.size());
				Cartas.this.setVisible(true);
				if(pont1 == 21){
					JOptionPane.showMessageDialog(null, nomej11 + " você ganhou! Parabéns!");
					ganhador.setText("Ganhador: " + nomej11);
					perdedor.setText("Perdedor: " + nomej22);
					pegar1.setEnabled(false);
					pegar2.setEnabled(false);
					parar1.setEnabled(false);
					parar2.setEnabled(false);
				}
				
				
				if(pont1 > 21){
					JOptionPane.showMessageDialog(null, nomej11 + " você perdeu! Boa sorte na próxima!");
					JOptionPane.showMessageDialog(null, nomej22 + " você ganhou! Parabéns!");
					ganhador.setText("Ganhador: " + nomej22);
					perdedor.setText("Perdedor: " + nomej11);
					pegar1.setEnabled(false);
					pegar2.setEnabled(false);
					parar2.setEnabled(false);
					parar1.setEnabled(false);
				}
				
				
				if(pont1 > 21){
					pegar2.setEnabled(false);
				}
				
				if(parar2.isEnabled() == false){
					pegar2.setEnabled(false);
					pegar1.setEnabled(true);
					
					if(pont1 > 21){
						pegar1.setEnabled(false);
					}
				}
				
				if(pont1 == 21){
					pegar1.setEnabled(false);
				}
				
			}
			
			
		});
		
	
		
		pegar2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				limg.setVisible(false);
				
				Random rand = new Random();
				int sorteio2 = rand.nextInt(janMeAbriu.baralho.size());
				
				Cartas.this.setVisible(false);
				String carta22 = "imagem/"+janMeAbriu.baralho.get(sorteio2).getCartas()+janMeAbriu.baralho.get(sorteio2).getNaipe()+".png";
				
				ImageIcon img = new ImageIcon(carta22);
				limg = new JLabel(img);
				limg.setBounds(300, 40, 200, 270);
				add(limg);
				
				
				pont2 += janMeAbriu.baralho.get(sorteio2).getValor();
				pontj2.setText("Pontuação: " + pont2);
				
				ganhar2();
				perder2();
				continuar2();
				
				pegar2.setEnabled(false);
				pegar1.setEnabled(true);
				janMeAbriu.baralho.remove(sorteio2);
				qtd.setText("Quantidade de cartas: " + janMeAbriu.baralho.size());
				Cartas.this.setVisible(true);
				
				if(pont2 == 21){
					JOptionPane.showMessageDialog(null, nomej22 + " você ganhou! Parabéns!");
					ganhador.setText("Ganhador: " + nomej22);
					perdedor.setText("Perdedor: " + nomej11);
					pegar2.setEnabled(false);
					pegar1.setEnabled(false);
					parar2.setEnabled(false);
					parar1.setEnabled(false);
				}
				
				
				if(pont2 > 21){
					JOptionPane.showMessageDialog(null, nomej22 + " você perdeu! Boa sorte na próxima!");
					JOptionPane.showMessageDialog(null, nomej11 + " você ganhou! Parabéns!");
					ganhador.setText("Ganhador: " + nomej11);
					perdedor.setText("Perdedor: " + nomej22);
					pegar2.setEnabled(false);
					pegar1.setEnabled(false);
					parar1.setEnabled(false);
					parar2.setEnabled(false);
			
				}
			

				
				if(pont2 > 21){
					pegar1.setEnabled(false);
				}
				
				if(parar1.isEnabled() == false){
					pegar1.setEnabled(false);
					pegar2.setEnabled(true);
					
					if(pont2 > 21){
						pegar2.setEnabled(false);
					}
				}
				
				if(pont2 == 21){
					pegar2.setEnabled(false);
				}
				
				
				
			}
			
			
		});
		
		parar1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pegar1.setEnabled(false);
				JOptionPane.showMessageDialog(null, nomej11 + " parou com " + pont1 + " pontos");
				parar1.setEnabled(false);
				if(pegar2.isEnabled() == false && parar2.isEnabled() == true){
					pegar2.setEnabled(true);
				}
				
				if(parar2.isEnabled() == false && parar1.isEnabled() == false){
					if(pont1 > pont2){
						JOptionPane.showMessageDialog(null, nomej11 + " você ganhou! Parabéns!");
						ganhador.setText("Ganhador: " + nomej11);
						perdedor.setText("Perdedor: " + nomej22);
					}
				}
				
				if(parar2.isEnabled() == false && parar1.isEnabled() == false){
					if(pont2 == pont1){
						JOptionPane.showMessageDialog(null, "O jogo terminou empatado!");
					}
				}
				
			}
		});
		
		parar2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pegar2.setEnabled(false);
				JOptionPane.showMessageDialog(null, nomej22 + " parou com " + pont2 + " pontos");
				parar2.setEnabled(false);
				if(pegar1.isEnabled() == false && parar1.isEnabled() == true){
					pegar1.setEnabled(true);
				}
				if(parar1.isEnabled() == false && parar2.isEnabled() == false){
					if(pont2 > pont1){
						JOptionPane.showMessageDialog(null, nomej22 + " você ganhou! Parabéns!");
						ganhador.setText("Ganhador: " + nomej22);
						perdedor.setText("Perdedor: " + nomej11);
					}
				}
				
				if(parar2.isEnabled() == false && parar1.isEnabled() == false){
					if(pont2 == pont1){
						JOptionPane.showMessageDialog(null, "O jogo terminou empatado!");
					}
				}
				
			}
		});
		
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cartas.this.dispose();
				
			}
		});
		
		voltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cartas.this.dispose();
				janMeAbriu.setVisible(true);
				
			}
		});
		
	}
	
	public float ganhar1(){
		pontfalta1 = 21 - pont1;
		int qtdCartas1 = 0;
		float pganhar = 0;
		
		for(int i = 0; i < janMeAbriu.baralho.size(); i++){
			
			if( janMeAbriu.baralho.get(i).getValor() == pontfalta1 ){
				
				qtdCartas1 = qtdCartas1 + 1;
				
			}
			
		}
	
		pganhar = (qtdCartas1 * 100) / janMeAbriu.baralho.size();
		ganhar1.setText("Ganhar: " + pganhar + " %");
		return pganhar;
	
	}
	
	public float ganhar2(){
		pontfalta2 = 21 - pont2;
		int qtdCartas2 = 0;
		float pganhar2 = 0;

		for(int i = 0; i < janMeAbriu.baralho.size(); i++){
			
			if( janMeAbriu.baralho.get(i).getValor() == pontfalta2 ){
				
				qtdCartas2 = qtdCartas2 + 1;
				
			}
			
		}
		
		pganhar2 = (qtdCartas2 * 100) / janMeAbriu.baralho.size();
		ganhar2.setText("Ganhar: " + pganhar2 + " %");
		return pganhar2;
	
	}
	
	public float perder1(){
		int qtdCartasPerder = 0;
		float pperder = 0;
		
		for(int i = 0; i < janMeAbriu.baralho.size(); i++){
			
			if(janMeAbriu.baralho.get(i).getValor() + pont1 > 21 ){
				qtdCartasPerder += 1;
			}
			
		}
		
		pperder = (qtdCartasPerder * 100) / janMeAbriu.baralho.size();
		perder1.setText("Perder: " + pperder + " %");
		
		return pperder;
	}
	
	public float perder2(){
		int qtdCartasPerder2 = 0;
		float pperder2 = 0;
		
		for(int i = 0; i < janMeAbriu.baralho.size(); i++){
			
			if(janMeAbriu.baralho.get(i).getValor() + pont2 > 21 ){
				qtdCartasPerder2 += 1;
			}
			
		}
		
		pperder2 = (qtdCartasPerder2 * 100) / janMeAbriu.baralho.size();
		perder2.setText("Perder: " + pperder2 + " %");
		
		return pperder2;
	}
	
	public float continuar1(){
		pontfalta1 = 21 - pont1;
		
		int qtdcartascont = 0;
		float pcontinuar = 0;
		
		for(int i = 0; i < janMeAbriu.baralho.size(); i++){
			
			if(janMeAbriu.baralho.get(i).getValor() + pont1 < 21){
				qtdcartascont += 1;
			}
		}
		
		pcontinuar = (qtdcartascont * 100) / janMeAbriu.baralho.size();
		continuar1.setText("Continuar: " + pcontinuar + " %");
		
		return pcontinuar;
		
		
	}
	
	public float continuar2(){
		
		pontfalta2 = 21 - pont2;
		
		int qtdcartascont2 = 0;
		float pcontinuar2 = 0;
		
		for(int i = 0; i < janMeAbriu.baralho.size(); i++){
			
			if(janMeAbriu.baralho.get(i).getValor() + pont2 < 21){
				qtdcartascont2 += 1;
			}
		}
		
		pcontinuar2 = (qtdcartascont2 * 100) / janMeAbriu.baralho.size();
		continuar2.setText("Continuar: " + pcontinuar2 + " %");
		
		return pcontinuar2;
		
		
		
	}
	

}
	
