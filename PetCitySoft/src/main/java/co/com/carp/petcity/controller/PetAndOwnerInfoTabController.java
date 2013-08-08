package co.com.carp.petcity.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import co.com.carp.petcity.entity.Owner;
import co.com.carp.petcity.entity.Pet;
import co.com.carp.petcity.entity.PetBreed;
import co.com.carp.petcity.entity.PetType;
import co.com.carp.petcity.view.JPOwnerInfo;
import co.com.carp.petcity.view.JPPetCardList;

public class PetAndOwnerInfoTabController {
	
	/**
	 * Copy from actual set that is being displayed
	 */
	private Set<Owner> ownerSet;
	
	/**
	 * Copy from owner information's panel
	 */
	private JPOwnerInfo jpOwnerInfo;
	
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
		
		Pet pet = new Pet();
		pet.setIdentification(1);
		pet.setName("Rita");
		pet.setBornDate(new Date());
		pet.setBornPlace("La caracas");
		
		Pet pet2 = new Pet();
		pet2.setIdentification(2);
		pet2.setName("Mia");
		pet2.setBornDate(new Date());
		pet2.setBornPlace("La caracas");
		
		PetType type = new PetType();
		type.setIdentification(1);
		type.setName("Canino");
		
		PetType type2 = new PetType();
		type2.setIdentification(1);
		type2.setName("Canino");
		
		Map<Integer, PetBreed> breedMap = new TreeMap<>();
		PetBreed breed = new PetBreed();
		breed.setIdentification(1);
		breed.setName("Beagle");
		breedMap.put(breed.getIdentification(), breed);
		
		breed = new PetBreed();
		breed.setIdentification(2);
		breed.setName("Cocker");
		breedMap.put(breed.getIdentification(), breed);
		
		type.setBreedMap(breedMap);
		type.setBreedSelected(1);
		pet.setType(type);
		type2.setBreedMap(breedMap);
		type2.setBreedSelected(2);
		pet2.setType(type2);
		
		Set<Pet> petSet = new HashSet<>();
		petSet.add(pet);
		petSet.add(pet2);
		owner.setPetSet(petSet);
		this.ownerSet.add(owner);
		
		owner = new Owner();
		owner.setIdentification(2);
		owner.setDocumentId(1045676080);
		owner.setName("Lina Florez");
		this.ownerSet.add(owner);
		
		return this.ownerSet;
	}
	
	/**
	 * It keeps a copy from central panel, this copy can be used to change the owner
	 * being displayed.
	 * 
	 * @param jpOwnerInfo Panel with owner info.
	 */
	public void keepCopyFromOwnerInfoPanel(JPOwnerInfo jpOwnerInfo) {
		this.jpOwnerInfo = jpOwnerInfo;
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
		if (this.jpOwnerInfo.replaceOwnerInformation(owner)) {
			this.changePetCardList(owner.getPetSet());
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
}
