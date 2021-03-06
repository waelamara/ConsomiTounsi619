package tn.esprit.spring.Controller.Panier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;


import tn.esprit.spring.Model.Commande;
import tn.esprit.spring.Model.Facture;
import tn.esprit.spring.Model.Livreur;
import tn.esprit.spring.Model.lignecommandeproduit;
import tn.esprit.spring.Model.Produit.Produit;
import tn.esprit.spring.Service.Panier.CommandeImpl;
import tn.esprit.spring.Service.Panier.FactureImpl;


@RestController
@RequestMapping("/Facture")
public class RestFactureController {
	
	@Autowired
	FactureImpl factureDAO;
	
	@Autowired
	CommandeImpl commandeDao;
	
	@Autowired
	ServletContext context;
	
	
	//http://localhost:8081/Facture/ajouter/{idCommande}
	@PostMapping("/ajouter/{idCommande}")
	public ResponseEntity <Facture> AjouterFacture(@PathVariable(value = "idCommande") Long idCommande,@Valid @RequestBody Facture f) 
			
	{
		Commande c =  commandeDao.findOne( idCommande);
		f.setCommande(c);
		factureDAO.save(f);
		return ResponseEntity.ok().build();
	
	}
	
	
	//http://localhost:8081/Facture/afficher
	@GetMapping("/afficher")
	public List<Facture > getAllFacture(){
		
		return factureDAO.findAll();
		
	}
	
	
	//http://localhost:8081/Facture/delete/{id}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Facture> DeleteProduit(@PathVariable(value = "id") Long idFacture) {
		Facture f = factureDAO.findOne(idFacture);
		if (f == null) {
			return ResponseEntity.notFound().build();
		}
		factureDAO.Delete(f);
		return ResponseEntity.ok().build();
	}
	
	
	//http://localhost:8081/Facture/{idUser}
	@GetMapping("/{idUser}")
	public List<lignecommandeproduit>FactureParIdUser(@PathVariable(value = "idUser") long id) {
	
		return factureDAO.FactureParIdUser(id);
	}
	
	
	//http://localhost:8081/Facture/afficherPDF/{idUser}
	@GetMapping("/afficherPDF/{idUser}")
	public void createpdf(HttpServletRequest request ,HttpServletResponse reponse,@PathVariable(value = "idUser") long id) throws MalformedURLException, IOException 
	{
	List<lignecommandeproduit> commandes =factureDAO.FactureParIdUser(id);
	boolean flag = factureDAO.CreePdf(commandes, context, request, reponse);
	if(flag)
	{
		String fullpath = request.getServletContext().getRealPath("/resources/report/" + "employees" + ".pdf");
		fileDownload(fullpath,reponse,"employees.pdf");
	
	}
	}
	
	
	private void fileDownload(String fullpath,HttpServletResponse reponse,String fileName)
	{
		File f = new File(fullpath);
		final int buffer = 4096;
		
		if(f.exists())
		{
		try{
			FileInputStream inputStream = new FileInputStream(f);
			String mineType = context.getMimeType(fullpath);
			reponse.setContentType(mineType);
			//reponse.setHeader(""content-disposition:inline;", "filename="+fileName);"
					reponse.setHeader("content-disposition:inline; ", "filename="+ fileName);
			OutputStream outputStream = reponse.getOutputStream();
			byte[] buffers = new byte[buffer];
			int bytesRead = -1;
			while((bytesRead=inputStream.read(buffers))!=-1)
			{
				outputStream.write( buffers,0,bytesRead );
			}
			inputStream.close();
			outputStream.close();
			f.delete();
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}
				
	}
	
	
	//http://localhost:8081/Facture/afficherPDF2/{idFacture}
	@GetMapping("/afficherPDF2/{idFacture}")
	public void facturepdf (@PathVariable(value = "idFacture")int id_facture)
	{
		factureDAO.facturepdf(id_facture);
	}
	
	}
	


