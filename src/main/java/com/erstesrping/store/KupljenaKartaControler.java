/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import com.erstesrping.store.model.KupljenaKarta;
import com.erstesrping.store.service.KupljenaKartaService;
import jakarta.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openpdf.text.Document;
import org.openpdf.text.Font;
import org.openpdf.text.Image;
import org.openpdf.text.PageSize;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author darko
 */
@RestController
@RequestMapping("/api/karte")
public class KupljenaKartaControler {

    private final KupljenaKartaService service;

    public KupljenaKartaControler(KupljenaKartaService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KupljenaKarta create(@RequestBody KupljenaKarta karta) {
        return service.create(karta);
    }

    @GetMapping("/{user_id}")
    public List<KupljenaKarta> findByUser(@PathVariable Long user_id) {
        return service.findByUser(user_id);
    }

    @GetMapping("/pdf/{id}")
    public void kartaPdf(@PathVariable Long id, HttpServletResponse response) throws Exception {

        KupljenaKarta karta = service.findById(id);

        response.setContentType("application/pdf");
        response.setHeader(
                "Content-Disposition",
                "attachment; filename=karta_" + id + ".pdf"
        );

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font titleFont = new Font(Font.HELVETICA, 20, Font.BOLD);
        Font textFont = new Font(Font.HELVETICA, 14);
        
        ClassPathResource cpr = new ClassPathResource("static/images/mytravel.png");
        Image img = Image.getInstance(cpr.getURL());
        img.scaleToFit(200, 160);
        img.setAlignment(Image.ALIGN_LEFT);
        document.add(img);
        
        document.add(new Paragraph("Potvrda o kupovini avionske karte", titleFont));
        document.add(new Paragraph(" "));

        document.add(new Paragraph(
                "Kupac: " + karta.getKupac().getUsername(),
                textFont
        ));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(
                "Relacija: "
                + karta.getLet().getIz().getNaziv()
                + " - "
                + karta.getLet().getKa().getNaziv(),
                textFont
        ));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"); 
        document.add(new Paragraph(
                "Vreme leta: "
                + karta.getLet().getVreme().format(formatter),
                textFont
        ));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(
                "Tip karte: "
                + karta.getTipKarte().getNaziv(),
                textFont
        ));
        
        document.add(new Paragraph(
                "Prtljag: "
                + karta.getTipKarte().getPrtljag(),
                textFont
        ));
        
                document.add(new Paragraph(
                "Dodatne usluge: "
                + karta.getTipKarte().getDodusl(),
                textFont
        ));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(
                "Cena: "
                + karta.getCena() + " EUR",
                textFont
        ));

        document.close();
    }
}
