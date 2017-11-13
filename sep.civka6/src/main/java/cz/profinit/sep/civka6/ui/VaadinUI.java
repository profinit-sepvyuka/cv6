package cz.profinit.sep.civka6.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.LocalDateToDateConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.ItemClick;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.ItemClickListener;

import cz.profinit.sep.civka6.dao.ObjektDao;
import cz.profinit.sep.civka6.model.ObjektKUlozeni;
import cz.profinit.sep.civka6.validators.AboValidator;
import cz.profinit.sep.civka6.validators.NotWeekendValidator;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {
	
	@Autowired
	private ObjektDao dao;

	private TextField sourceAbo; 
	private AbstractField<String> targetAbo; 
	private AbstractField<String> amount; 
	private AbstractField<LocalDate> date;
	private Long id = null;

	private Grid<ObjektKUlozeni> grid; 
	
    @Override
    protected void init(VaadinRequest request) {
    	VerticalLayout mainLayout = new VerticalLayout();
    	
    	mainLayout.addComponent(createObjektGrid());
    	
    	mainLayout.addComponent(createSourceAbo("Zdroj iban"));
    	mainLayout.addComponent(createTargetIban("Cil iban"));
    	mainLayout.addComponent(createAmount("Castka"));
    	mainLayout.addComponent(createDate("Datum iban"));
    	
    	mainLayout.addComponent(createSaveButton());
    	
    	setContent(mainLayout);
    }

	private Button createSaveButton() {
		Button result = new Button("Ulozit");
		
		result.addClickListener(ClickListener -> {
			ObjektKUlozeni obj;
			
			if (id == null) {
				obj = new ObjektKUlozeni();
			} else {
				obj = dao.findOne(id);
			}
			
			obj.setAmount(new BigDecimal(amount.getValue()));
			obj.setDate(Date.from(date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			obj.setTargetAbo(targetAbo.getValue());
			obj.setSourceAbo(sourceAbo.getValue());
			dao.save(obj);
			
			id = null;
			
			listCustomers();
		});
		
		return result;
	}
	
	private Component createObjektGrid() {
		this.grid = new Grid<>(ObjektKUlozeni.class);
		listCustomers();
		
		grid.addItemClickListener(new ItemClickListener<ObjektKUlozeni>() {

			@Override
			public void itemClick(ItemClick<ObjektKUlozeni> event) {
				ObjektKUlozeni item = event.getItem();
				sourceAbo.setValue(item.getSourceAbo());
				targetAbo.setValue(item.getTargetAbo());
				amount.setValue(item.getAmount() == null ? null : item.getAmount().toString());
				date.setValue(item.getDate() == null ? null : item.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				
				id = item.getId();
			}
			
		});
		
		return grid;
	}
    
	private void listCustomers() {
	    grid.setItems(dao.findAll());
	}
	
    private Component createDate(String text) {
    	Label label = new Label(text);
    	date = new DateField();
    	new Binder<ObjektKUlozeni>().forField(date).withValidator(new NotWeekendValidator(""))
    		.withConverter(new LocalDateToDateConverter())
			.bind(ObjektKUlozeni::getDate, ObjektKUlozeni::setDate);

    	return new HorizontalLayout(label, date);
	}

	private Component createSourceAbo(String text) {
    	Label label = new Label(text);
    	sourceAbo = new TextField();
    	new Binder<ObjektKUlozeni>().forField(sourceAbo).withValidator(new AboValidator(""))
    		.bind(ObjektKUlozeni::getSourceAbo, ObjektKUlozeni::setSourceAbo);
    	
    	return new HorizontalLayout(label, sourceAbo);
    }
	
	private Component createTargetIban(String text) {
		Label label = new Label(text);
		targetAbo = new TextField();
		
		return new HorizontalLayout(label, targetAbo);
	}
	
	private Component createAmount(String text) {
		Label label = new Label(text);
		amount = new TextField();
		
		return new HorizontalLayout(label, amount);
	}
	
	
}