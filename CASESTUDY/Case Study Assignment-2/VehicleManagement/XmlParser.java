package VehicleManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * @author Deepali
 *
 */
public class XmlParser {


	/**To read Xml File
	 * @param configFile :path of Xml File
	 * @return :List of Vehicle Object
	 */
	public List<Vehicle> readConfig(String configFile) {
		List<Vehicle> vehicleObjectList = new ArrayList<Vehicle>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			File f=new File(configFile).getAbsoluteFile();
			XMLEventReader eventReader = inputFactory.createXMLEventReader(new FileInputStream(f));
			// read the XML document
			Vehicle objVehicle = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();//getting event
				//for starting of event
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					// If we have an item element, we create a new item
					if (startElement.getName().getLocalPart()
							.equals(VehicleType.Car.toString())) {
						objVehicle = new Car();
					} else if (startElement.getName().getLocalPart()
							.equals(VehicleType.Bike.toString())) {
						objVehicle = new Bike();
					}

					if (event.isStartElement()) {
						if (event.asStartElement().getName().getLocalPart()
								.equals(Events.vehicleId.toString())) {
							event = eventReader.nextEvent();
							objVehicle.setVehicleId(Integer.parseInt(event
									.asCharacters().getData()));
							continue;
						}
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.make.toString())) {
						event = eventReader.nextEvent();
						objVehicle.setMake(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.model.toString())) {
						event = eventReader.nextEvent();
						objVehicle.setModel(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.engineInCC.toString())) {
						event = eventReader.nextEvent();
						objVehicle.setEngineInCC(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.fuelCapacity.toString())) {
						event = eventReader.nextEvent();
						objVehicle.setFuelCapacity(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.milage.toString())) {
						event = eventReader.nextEvent();
						objVehicle.setMilage(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.price.toString())) {
						event = eventReader.nextEvent();
						objVehicle.setPrice(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.roadTax.toString())) {
						event = eventReader.nextEvent();
						objVehicle.setRoadTax(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.createdBy.toString())) {
						event = eventReader.nextEvent();
						objVehicle.setCreatedBy(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.ac.toString())) {
						event = eventReader.nextEvent();
						((Car) objVehicle).setAC(Boolean.valueOf(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.powerStering.toString())) {
						event = eventReader.nextEvent();
						((Car) objVehicle).setPowerSteering(Boolean
								.valueOf(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.accessoryKit.toString())) {
						event = eventReader.nextEvent();
						((Car) objVehicle).setAccessoryKit(Boolean
								.valueOf(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.selfStart.toString())) {
						event = eventReader.nextEvent();
						((Bike) objVehicle).setSelfStart(Boolean.valueOf(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(Events.helmetPrice.toString())) {
						event = eventReader.nextEvent();
						((Bike) objVehicle).setHelmetPrice(Integer
								.parseInt(event.asCharacters().getData()));
						continue;
					}

				}
				// If we reach the end of a vehicle element, we add it to the
				// list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement(); //getting end element of event
					if (endElement.getName().getLocalPart()
							.equals(VehicleType.Car.toString())
							|| endElement.getName().getLocalPart()
									.equals(VehicleType.Bike.toString()))
						vehicleObjectList.add(objVehicle);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return vehicleObjectList;
	}

}