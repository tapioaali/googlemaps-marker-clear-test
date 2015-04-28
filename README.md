# Google Maps Marker Clearing Test Application #

An app created to test `GoogleMap#clearMarkers()` which worked unexpectedly at some point. See it running at [tapio.app.fi](http://tapio.app.fi/googlemaps-clearmarkers-test/).

This project serves also as a simple example Eclipse project for the add-on. Please notice that it contains all JARs required by Google Maps (including `gwt-ajaxloader` and `gwt-maps-api`) in `WEB-INF/lib` instead of using Ivy to manage them. 

**NOTICE:** in most cases you don't want to add the JARs manually to the project. In order to use Ivy correctly as the dependency manager for the Google Maps dependecies too, just remove all JARs from `WebContent/WEB-INF/lib/` and then add following dependency to `Ivy.xml`:

  <dependency org="com.vaadin.tapio" name="googlemaps" rev="1.0.2" />

For full add-on check out its [GitHub page](https://github.com/tjkaal/GoogleMapsVaadin7). 

The add-on is also available at [Vaadin Directory](https://vaadin.com/directory#!addon/googlemaps-add-on).
