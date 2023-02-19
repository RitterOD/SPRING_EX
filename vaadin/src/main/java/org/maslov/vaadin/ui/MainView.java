package org.maslov.vaadin.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.extern.slf4j.Slf4j;

@Route("/app")
//@SpringComponent
@Slf4j
public class MainView extends VerticalLayout {

  private Label label;
  private Button addBtn;
  private Button subBtn;

  public MainView() {
    log.info("IN MAIN VIEW CONSTRUCTOR");
    addBtn = new Button("Add counter", VaadinIcon.PLUS.create());
    addBtn.setHeight("200px");
    addBtn.setWidth("200px");
    subBtn = new Button("Decrement counter", VaadinIcon.MINUS.create());
    subBtn.setHeight("200px");
    subBtn.setWidth("200px");
    label = new Label("0");
    addBtn.setVisible(true);
    subBtn.setVisible(true);
    label.setVisible(true);
    addBtn.addClickListener((e) -> { log.info("ADD clicked");
      long value = Long.parseLong(label.getText()) + 1L;
      this.label.setText(Long.toString(value)) ;});
    subBtn.addClickListener((e) -> { log.info("SUB clicked");
      long value = Long.parseLong(label.getText()) - 1L;
      this.label.setText(Long.toString(value));
    });
    add(addBtn);
    add(subBtn);
    add(label);
    this.setVisible(true);
  }
}
