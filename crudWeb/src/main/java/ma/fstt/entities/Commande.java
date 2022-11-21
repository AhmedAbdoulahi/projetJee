package ma.fstt.entities;

import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Commande {
	private Long id ;
	private Date date_cmd ;
	private int cli ;
	private List<LignedeCommande> lc ;
	
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(Date date_cmd, int cli) {
		super();
		this.date_cmd = date_cmd;
		this.cli = cli;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate_cmd() {
		return date_cmd;
	}
	public void setDate_cmd(Date date_cmd) {
		this.date_cmd = date_cmd;
	}
	public int getCli() {
		return cli;
	}
	public void setCli(int cli) {
		this.cli = cli;
	}
	
	
}
