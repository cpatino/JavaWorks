package co.com.carp.petcity.controller;

import static co.com.carp.petcity.view.JTPetCityTools.TOOLBAR_OWNER_PET_INFO_ACTION_HISTORY;
import static co.com.carp.petcity.view.JTPetCityTools.TOOLBAR_OWNER_PET_INFO_ACTION_NEW_NOTE;
import static co.com.carp.petcity.view.JTPetCityTools.TOOLBAR_OWNER_PET_INFO_ACTION_OWNER;
import static co.com.carp.petcity.view.JTPetCityTools.TOOLBAR_OWNER_PET_INFO_ACTION_PET;
import static co.com.carp.petcity.view.JTPetCityTools.TOOLBAR_OWNER_PET_INFO_ACTION_SAVE;
import static co.com.carp.petcity.view.JTPetCityTools.TOOLBAR_OWNER_PET_INFO_ACTION_VIEW_NOTES;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.com.carp.petcity.dao.OwnerDao;
import co.com.carp.petcity.entity.Owner;
import co.com.carp.petcity.entity.Pet;
import co.com.carp.petcity.entity.PetBreed;
import co.com.carp.petcity.entity.PetType;
import co.com.carp.petcity.view.JDClinicHistorySummary;
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
		OwnerDao ownerDao = new OwnerDao();
		this.ownerSet = new HashSet<Owner>(ownerDao.selectAll());
		//Fake data
		/*Owner owner = new Owner();
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
		pet.setReproduction(Pet.REPRODUCTION_ENTIRE);
		try {
			pet.setBornDate(format.parse("06/05/2013"));
		} catch (ParseException ex) {
			Logger.getLogger(this.getClass()).error(ex.getMessage());
		}
		pet.setBornPlace("La caracas");
		
		Pet pet2 = new Pet();
		pet2.setIdentification(2);
		pet2.setName("Mia");
		pet2.setSex(Pet.PET_SEX_FEMALE);
		pet2.setColor("Dorado");
		pet2.setReproduction(Pet.REPRODUCTION_ENTIRE);
		try {
			pet2.setBornDate(format.parse("13/05/2013"));
		} catch (ParseException ex) {
			Logger.getLogger(this.getClass()).error(ex.getMessage());
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
		*/
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
		breed.setPetType(typeCanino);
		breedSet.add(breed);
		
		breed = new PetBreed();
		breed.setIdentification(2);
		breed.setName("Cocker");
		breed.setPetType(typeCanino);
		breedSet.add(breed);
		
		breed = new PetBreed();
		breed.setIdentification(3);
		breed.setName("Pitbull");
		breed.setPetType(typeCanino);
		breedSet.add(breed);
		
		breed = new PetBreed();
		breed.setIdentification(4);
		breed.setName("Chow chow");
		breed.setPetType(typeCanino);
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
	 * It tries to replace the information being displayed on {@link JPOwnerInfo} panel.
	 * 
	 * @param owner {@link Owner} to be displayed.
	 */
	public void changeOwnerInOwnerInfoPanel(Owner owner) {
		Owner originalOwner = (Owner)this.jpOwnerInfo.getObjectOriginal();
		Owner displayedOwner = (Owner)this.jpOwnerInfo.getObjectDisplayed();
		Pet originalPet = (Pet)this.jpPetInfo.getObjectOriginal();
		Pet displayedPet = (Pet)this.jpPetInfo.getObjectDisplayed();
		if ((owner == null || originalOwner == null)
				|| (owner.getIdentification() != originalOwner.getIdentification())) {
			int result = JOptionPane.NO_OPTION;			
			if ((this.jpOwnerInfo.isChangeNotified() && !originalOwner.equals(displayedOwner))
					|| (this.jpPetInfo.isChangeNotified() && !originalPet.equals(displayedPet))) {
				result = JOptionPane.showConfirmDialog(null, "�Desea guardar los datos?",
						"Algunos datos fueron cambiados", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
			}
			if (result != JOptionPane.CANCEL_OPTION) {
				if (result == JOptionPane.YES_OPTION) {					
					//TODO: Make save action here. 
				}
				this.jpOwnerInfo.updateInformation(owner);
				Pet pet = null;
				if (owner.getPetSet() != null) {
					pet = (Pet) owner.getPetSet().toArray()[0];
				}
				this.changePetInPetInfoPanel(pet, false);
				this.changePetCardList(owner.getPetSet());
				this.jtPetCityTools.makeEnableSaveAction(false);
			}
		}
	}
	
	/**
	 * It tries to replace the information being displayed on {@link JPPetInfo} panel.
	 * 
	 * @param pet {@link Pet} to be displayed.
	 */
	public void changePetInPetInfoPanel(Pet pet) {
		this.changePetInPetInfoPanel(pet, true);		
	}
	/**
	 *  It tries to replace the information being displayed on {@link JPPetInfo} panel, 
	 *  if it's necessary, it will display a message to ask for user's confirmation in 
	 *  order to save data changed.
	 * 
	 * @param pet {@link Pet} to be displayed.
	 * @param showMessage True if it will display validation message, false otherwise.
	 */
	private void changePetInPetInfoPanel(Pet pet, boolean showMessage) {
		Pet originalPet = (Pet)this.jpPetInfo.getObjectOriginal();
		Pet displayedPet = (Pet)this.jpPetInfo.getObjectDisplayed();
		if ((pet == null || originalPet == null)
				|| (pet.getIdentification() != originalPet.getIdentification())) {
			int result = JOptionPane.NO_OPTION;
			if (showMessage && this.jpPetInfo.isChangeNotified() && !originalPet.equals(
					displayedPet)) {
				result = JOptionPane.showConfirmDialog(null, "�Desea guardar los datos?", 
						"Algunos datos fueron cambiados", JOptionPane.YES_NO_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
			}
			if (result != JOptionPane.CANCEL_OPTION) {
				if (result == JOptionPane.YES_OPTION) {
					//TODO: Make save action here.
				}
				this.jpPetInfo.updateInformation(pet);
				this.jtPetCityTools.makeEnableSaveAction(false);
			}
		}
		this.jtPetCityTools.makeEnableActionsForPet(pet != null ? true : false);
	}
	
	/**
	 * It replaces the pet set that is being displayed on owner info panel.
	 * 
	 * @param petSet The pet set linked to user that will be displayed.
	 */
	private void changePetCardList(Set<Pet> petSet) {
		this.jpPetCard.updateCards(petSet);
	}
	
	/**
	 * It allow execute an action after receive notification from {@link JTPetCityTools}.
	 * 
	 * @param action {@link String} with action to be executed.
	 */
	private void executeToolBarAction(String action) {
		switch (action) {
		case TOOLBAR_OWNER_PET_INFO_ACTION_SAVE:
			this.saveAction();
			break;
		case TOOLBAR_OWNER_PET_INFO_ACTION_OWNER:
			this.newOwnerAction();
			break;
		case TOOLBAR_OWNER_PET_INFO_ACTION_PET:
			this.newPetAction();
			break;
		case TOOLBAR_OWNER_PET_INFO_ACTION_HISTORY:
			this.viewClinicHistory();
			break;
		case TOOLBAR_OWNER_PET_INFO_ACTION_NEW_NOTE:
			this.newNoteAction();
			break;
		case TOOLBAR_OWNER_PET_INFO_ACTION_VIEW_NOTES:
			this.viewNotesAction();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Acci�n no valida");
			break;
		}
	}
	
	/**
	 * This action is called when user try to save information after click
	 * on tool bar button or when it was confirmed through message dialog.
	 */
	private void saveAction() {
		//TODO: Make save action here.
	}
	
	/**
	 * This action is called when user try to create a new owner.
	 */
	private void newOwnerAction() {
		//TODO: Make new user action here.
	}
	
	/**
	 * This action is called when user try to create a new pet for user.
	 */
	private void newPetAction() {
		//TODO: Make new pet action here.
	}
	
	/**
	 * This action is called when user try to display clinic history screen
	 * for selected pet.
	 */
	private void viewClinicHistory() {
		Pet pet = (Pet)this.jpPetInfo.getObjectOriginal();
		if (pet != null) {
			new JDClinicHistorySummary(pet).setVisible(true);
		}
	}
	
	/**
	 * This action is called when user try to create a new note for selected
	 * pet.
	 */
	private void newNoteAction() {
		//TODO: Make new note action here.
	}
	
	/**
	 * This action is called when user try to view all notes created.
	 */
	private void viewNotesAction() {
		//TODO: Make view notes action here.
	}
	
	@Override
	public void update(Observable observable, Object object) {
		if (observable instanceof JPOwnerCardList) {
			this.changeOwnerInOwnerInfoPanel((Owner)object);
		} else if (observable instanceof JPPetCardList) {
			this.changePetInPetInfoPanel((Pet)object);
		} else if (observable instanceof JPOwnerInfo) {
			this.jtPetCityTools.makeEnableSaveAction(true);
		} else if (observable instanceof JPPetInfo) {
			this.jtPetCityTools.makeEnableSaveAction(true);
		} else if (observable instanceof JTPetCityTools) {
			this.executeToolBarAction((String)object);
		}
	}

}
