package com.vaadin.googlemaps;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Version;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
public class GoogleMapsMarkerClearTestUI extends UI {

    private static final String vaadinVersion = Version.getFullVersion();
    private String versionString = String.format("Using Vaadin version %s",
            vaadinVersion);

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = GoogleMapsMarkerClearTestUI.class, widgetset = "com.vaadin.googlemaps.Widgetset")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);

        Label versionLabel = new Label(versionString);
        layout.addComponent(versionLabel);

        final GoogleMap googleMap = new GoogleMap(null, null, null);
        googleMap.setCenter(new LatLon(60.440963, 22.25122));
        googleMap.setZoom(10);
        googleMap.setHeight("500px");
        googleMap.setWidth("650px");
        googleMap.addMarker(new GoogleMapMarker("Kakolan vankila", new LatLon(
                60.44291, 22.242415), true, null));
        googleMap.addMarker("Paavo Nurmi Stadion", new LatLon(60.442423,
                22.26044), true, null);
        googleMap.addMarker("Iso-Heikkilä", new LatLon(60.450403, 22.230399),
                true, null);
        googleMap.setMinZoom(4);
        googleMap.setMaxZoom(16);
        layout.addComponent(googleMap);

        Button b = new Button("Clear markers", new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                googleMap.clearMarkers();
            }
        });
        layout.addComponent(b);
    }

}