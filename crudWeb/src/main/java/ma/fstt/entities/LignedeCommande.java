package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LignedeCommande {
	private Long num_ligne ;
	private Long idproduit ;
	private Long idcmd ;
	private double qte_cmd ;
	
	
	public LignedeCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LignedeCommande(Long num_ligne, Long idproduit, Long idcmd, double qte_cmd) {
		super();
		this.num_ligne = num_ligne;
		this.idproduit = idproduit;
		this.idcmd = idcmd;
		this.qte_cmd = qte_cmd;
	}

	public Long getNum_ligne() {
		return num_ligne;
	}
	public void setNum_ligne(Long num_ligne) {
		this.num_ligne = num_ligne;
	}
	public Long getIdproduit() {
		return idproduit;
	}
	public void setIdproduit(Long idproduit) {
		this.idproduit = idproduit;
	}
	public Long getIdcmd() {
		return idcmd;
	}
	public void setIdcmd(Long idcmd) {
		this.idcmd = idcmd;
	}
	public double getQte_cmd() {
		return qte_cmd;
	}
	public void setQte_cmd(double qte_cmd) {
		this.qte_cmd = qte_cmd;
	}
	
	
}
