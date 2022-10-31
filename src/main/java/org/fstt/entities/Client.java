package org.fstt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "client")
public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_cli")
	private Long codeClient;
	
	@Column(name = "nom_cli")
	private String nomClient;
	
	@Column(name = "pre_cli")
	private String prenomClient;
	
	@Column(name = "adr_cli")
	private String adresse;
	
	@Column(name = "tel_cli")
	private String telephone;
	
	@Column(name = "ville_cli")
	private String villeClient;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;
	
	@JsonManagedReference
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "client")
	private Collection<Commande> commandes = new ArrayList<Commande>();

	public Long getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getVilleClient() {
		return villeClient;
	}

	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}

	public Collection<Commande> getCommandes() {
		return (Collection<Commande>) commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	
	public void addCommande(Commande commande) {
		this.commandes.add(commande);
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Client(String nomClient, String prenomClient, String adresse, String telephone,
			String villeClient, ArrayList<Commande> commandes) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresse = adresse;
		this.telephone = telephone;
		this.villeClient = villeClient;
		this.commandes = commandes;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String res = "Client [codeClient=" + codeClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", adresse=" + adresse + ", telephone=" + telephone + ", villeClient=" + villeClient + ", userId="
				+ userId + ", commandes=\n";
		for(Commande c : commandes) {
			res += c.toString()+ "\n"; 
		}
		return res;
	}

}
