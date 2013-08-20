package co.com.carp.petcity.controller;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.com.carp.petcity.entity.Owner;
import co.com.carp.petcity.entity.Pet;
import co.com.carp.petcity.entity.PetBreed;
import co.com.carp.petcity.entity.PetType;
import co.com.carp.petcity.view.JFOwnerAndPetsInfo;
import co.com.carp.petcity.view.JPOwnerCardList;
import co.com.carp.petcity.view.JPOwnerInfo;
import co.com.carp.petcity.view.JPPetCardList;
import co.com.carp.petcity.view.JPPetInfo;
import co.com.carp.petcity.view.JTPetCityTools;

/**
 * This class is attempt to control all communication between panels done on
 * {@link JFOwnerAndPetsInfo}, it will be in control of all process and request
 * that {@link JFrame} request.
 * 
 * @author Carlos Rodriguez
 *
 */
public class OwnerAndPetsInfoController implements Observer {
	
	/**
	 * Copy from actual set that is being displayed
	 */
	private Set<Owner> ownerSet;
	
	/**
	 * Copy from {@link JTPetCityTools}
	 */
	private JTPetCityTools jtPetCityTools;
	
	/**
	 * Copy from owner information's panel
	 */
	private JPOwnerInfo jpOwnerInfo;
	
	/**
	 * Copy from pet information's panel
	 */
	private JPPetInfo jpPetInfo;
	
	/**
	 * Copy from pet card's scroll panel
	 */
	private JPPetCardList jpPetCard;
	
	/**
	 * It does a query to database using the parameter send.
	 * 
	 * @param toLookFor String value used to do query.
	 * @return Owner set with all information obtained from database.
	 */
	public Set<Owner> queryOwnerInfo(String toLookFor) {
		this.ownerSet = new TreeSet<>();
		//Fake data
		Owner owner = new Owner();
		owner.setIdentification(1);
		owner.setDocumentId(19604742);
		owner.setName("Carlos Rodriguez");
		owner.setCellphone(new BigInteger("3007200405"));
		owner.setAddress("");
		owner.setPhone(5109965);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Pet pet = new Pet();
		pet.setIdentification(1);
		pet.setName("Rita");
		pet.setSex(Pet.PET_SEX_FEMALE);
		pet.setColor("Limon");
		try {
			pet.setBornDate(format.parse("06/05/2013"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pet.setBornPlace("La caracas");
		
		Pet pet2 = new Pet();
		pet2.setIdentification(2);
		pet2.setName("Mia");
		pet2.setSex(Pet.PET_SEX_FEMALE);
		pet2.setColor("Dorado");
		try {
			pet2.setBornDate(format.parse("13/05/2013"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pet2.setBornPlace("La caracas");
		
		PetType typeCanino = new PetType();
		typeCanino.setIdentification(1);
		typeCanino.setName("Canino");
		
		PetBreed breed = new PetBreed();
		breed.setIdentification(1);
		breed.setName("Beagle");
		breed.setPetType(typeCanino);
		pet.setBreed(breed);
		
		breed = new PetBreed();
		breed.setIdentification(2);
		breed.setName("Cocker");
		breed.setPetType(typeCanino);
		pet2.setBreed(breed);
		
		Set<Pet> petSet = new HashSet<>();
		petSet.add(pet);
		petSet.add(pet2);
		owner.setPetSet(petSet);
		this.ownerSet.add(owner);
		
		owner = new Owner();
		owner.setIdentification(2);
		owner.setDocumentId(1045676080);
		owner.setName("Lina Florez");
		owner.setCellphone(new BigInteger("3007200405"));
		owner.setAddress("");
		owner.setPhone(5109965);
		this.ownerSet.add(owner);
		
		return this.ownerSet;
	}
	
	public Set<PetType> queryPetType() {
		Set<PetType> typeSet = new TreeSet<>();
		Set<PetBreed> breedSet = new TreeSet<>();
		
		PetType typeCanino = new PetType();
		typeCanino.setIdentification(1);
		typeCanino.setName("Canino");
		
		PetBreed breed = new PetBreed();
		breed.setIdentification(1);
		breed.setName("Beagle");
		breedSet.add(breed);
		
		breed = new PetBreed();
		breed.setIdentification(2);
		breed.setName("Cocker");
		breedSet.add(breed);
		
		breed = new PetBreed();
		breed.setIdentification(3);
		breed.setName("Pitbull");
		breedSet.add(breed);
		
		breed = new PetBreed();
		breed.setIdentification(4);
		breed.setName("Chow chow");
		breedSet.add(breed);
		
		typeCanino.setBreedSet(breedSet);
		typeSet.add(typeCanino);
		
		PetType typeFelino = new PetType();
		typeFelino.setIdentification(2);
		typeFelino.setName("Felino");
		typeSet.add(typeFelino);
		return typeSet;
	}
	
	/**
	 * It keeps a copy from {@link JTPetCityTools}, this copy can be used to do available
	 * buttons on it.
	 * 
	 * @param jtPetCityTools {@link JTPetCityTools} copy.
	 */
	public void keepCopyFromPetCityTools(JTPetCityTools jtPetCityTools) {
		this.jtPetCityTools = jtPetCityTools;
	}
	
	/**
	 * It keeps a copy from owner information panel, this copy can be used to change the owner
	 * being displayed.
	 * 
	 * @param jpOwnerInfo Panel with owner info.
	 */
	public void keepCopyFromOwnerInfoPanel(JPOwnerInfo jpOwnerInfo) {
		this.jpOwnerInfo = jpOwnerInfo;
	}
	
	/**
	 * It keeps a copy from pet information panel, this copy can be used to change the owner
	 * being displayed.
	 * 
	 * @param jpOwnerInfo Panel with owner info.
	 */
	public void keepCopyFromPetInfoPanel(JPPetInfo jpPetInfo) {
		this.jpPetInfo = jpPetInfo;
	}
	
	/**
	 * It keeps a copy from pet card panel, this copy can be used to change the pets
	 * being displayed.
	 * 
	 * @param jpPetCard Panel with all pets associated to an owner.
	 */
	public void keepCopyFromPetCardPanel(JPPetCardList jpPetCard) {
		this.jpPetCard = jpPetCard;
	}

	/**
	 * It tries to replace the information being displayed on owner info panel.
	 * 
	 * @param owner New owner to be displayed.
	 */
	public void changeOwnerInOwnerInfoPanel(Owner owner) {
		if (this.jpOwnerInfo != null) {
			int result = JOptionPane.NO_OPTION;
			if (!this.jpOwnerInfo.getObjectOriginal().equals(this.jpOwnerInfo.getObjectDisplayed())) {
				result = JOptionPane.showConfirmDialog(null, "�Desea guardar los datos?", "Algunos datos fueron cambiados", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			}
			if (result != JOptionPane.CANCEL_OPTION) {
				if (result == JOptionPane.YES_OPTION) {
					
				}
				if (this.jpOwnerInfo.updateInformation(owner)) {
					Pet pet = null;
					if (owner.getPetSet() != null) {
						pet = (Pet) owner.getPetSet().toArray()[0];
					}
					changePetInPetInfoPanel(pet);
					this.changePetCardList(owner.getPetSet());
				}
				
			}
		}
	}
	
	/**
	 * It tries to replace the information being displayed on pet info panel.
	 * 
	 * @param pet New pet to be displayed.
	 */
	public void changePetInPetInfoPanel(Pet pet) {
		if (this.jpPetInfo != null) {
			this.jpPetInfo.updateInformation(pet);
		}
	}
	
	/**
	 * It replaces the pet set that is being displayed on owner info panel.
	 * 
	 * @param petSet The pet set linked to user that will be displayed.
	 */
	private void changePetCardList(Set<Pet> petSet) {
		this.jpPetCard.updateCards(petSet);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof JPOwnerCardList) {
			this.changeOwnerInOwnerInfoPanel((Owner)arg);
		} else if (observable instanceof JPPetCardList) {
			this.changePetInPetInfoPanel((Pet)arg);
		} else if (observable instanceof JPOwnerInfo) {
			if (jtPetCityTools != null) {
				this.jtPetCityTools.makeEnableSaveAction(true);
			}
		}
	}

}
