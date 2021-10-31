package org.serendipity.party.database.seed.au;

import lombok.extern.slf4j.Slf4j;
import org.serendipity.party.entity.*;
import org.serendipity.party.repository.AddressRepository;
import org.serendipity.party.repository.IndividualRepository;
import org.serendipity.party.repository.OrganisationRepository;
import org.serendipity.party.repository.RoleRepository;
import org.serendipity.party.type.LocationType;
import org.serendipity.party.type.PartyType;
import org.serendipity.party.type.au.LegalType;
import org.serendipity.party.type.au.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Component
@Slf4j
@Order(2)
public class CentreAlliance implements CommandLineRunner {

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private IndividualRepository individualRepository;

  @Autowired
  private OrganisationRepository organisationRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {

    log.info("Create {} ...", PoliticalParty.CENTRE_ALLIANCE.toString());

    try {

      //
      // Head Office Address
      //

      // Timestamp currentTime = new Timestamp(System.currentTimeMillis());

      Location location = Location.builder()
        .type(LocationType.ADDRESS)
        .displayName("Unit 7 169 Unley Rd Unley SA 5061")
        // .fromDate(currentTime)
        .build();

      Address headOffice = Address.builder()
        .location(location)
        .name("")
        .line1("Unit 7")
        .line2("169 Unley Rd")
        .city("Unley")
        .state("SA")
        .postalCode("5061")
        .country("Australia")
        .addressType("Principle Place of Business")
        .build();

      addressRepository.save(headOffice);

      // Create the Primary Contact (Individual)

      Name name = Name.builder()
        .givenName("R")
        .familyName("Patrick")
        .build();

      Party individualParty = Party.builder()
        .type(PartyType.INDIVIDUAL)
        .displayName(name.getFamilyName() + ", " + name.getGivenName())
        .addresses(new HashSet<>())
        .roles(new HashSet<>())
        .build();

      Individual individual = Individual.builder()
        .party(individualParty)
        .name(name)
        .sex(Sex.MALE.toString())
        .email("r.patrick@centrealliance.org.au")
        .phoneNumber("(08) 8545 0400")
        .build();

      // Save the Primary Contact (Individual)

      individualRepository.save(individual);

      // Organisation

      Party organisationParty = Party.builder()
        .type(PartyType.ORGANISATION)
        .legalType(LegalType.OTHER_INCORPORATED_ENTITY.toString())
        .displayName(PoliticalParty.CENTRE_ALLIANCE.toString())
        .addresses(new HashSet<Address>())
        .roles(new HashSet<Role>())
        .build();

      Organisation organisation = Organisation.builder()
        .party(organisationParty)
        .name(PoliticalParty.CENTRE_ALLIANCE.toString())
        .email("hey@centrealliance.org.au")
        .phoneNumber("(08) 8545 0400")
        .build();

      organisationRepository.save(organisation);

      // | Party             | Role         | Relationship  | Role            | Party             |
      // | ----------------- | ------------ | --------------| --------------- | ----------------- |
      // | Australian Greens | Organisation | Office Bearer | Primary Contact | Jordan Hull       |
      // | Jordan Hull       | Member       | Membership    | Organisation    | Australian Greens |

      Role role = Role.builder()
        .partyId(organisation.getParty().getId())
        .partyType(organisation.getParty().getType())
        .partyName(organisation.getParty().getDisplayName())
        .partyEmail(organisation.getEmail())
        .partyPhoneNumber(organisation.getPhoneNumber())
        .role("Organisation")
        .relationship("Office Bearer")
        .reciprocalRole("Primary Contact")
        .reciprocalPartyId(individual.getParty().getId())
        .reciprocalPartyType(individual.getParty().getType())
        .reciprocalPartyName(individual.getParty().getDisplayName())
        .reciprocalPartyEmail(individual.getEmail())
        .reciprocalPartyPhoneNumber(individual.getPhoneNumber())
        .build();

      roleRepository.save(role);

      organisationParty.getAddresses().add(headOffice);
      organisationParty.getRoles().add(role);

      organisationRepository.save(organisation);

      Role reciprocalRole = Role.builder()
        .partyId(individual.getParty().getId())
        .partyType(individual.getParty().getType())
        .partyName(individual.getParty().getDisplayName())
        .partyEmail(individual.getEmail())
        .partyPhoneNumber(individual.getPhoneNumber())
        .role("Member")
        .relationship("Membership")
        .reciprocalRole("Organisation")
        .reciprocalPartyId(organisation.getParty().getId())
        .reciprocalPartyType(organisation.getParty().getType())
        .reciprocalPartyName(organisation.getParty().getDisplayName())
        .reciprocalPartyEmail(organisation.getEmail())
        .reciprocalPartyPhoneNumber(organisation.getPhoneNumber())
        .build();

      roleRepository.save(reciprocalRole);

      individualParty.getAddresses().add(headOffice);
      individualParty.getRoles().add(reciprocalRole);

      individualRepository.save(individual);

      log.info("Create {} complete", PoliticalParty.CENTRE_ALLIANCE.toString());

    } catch (Exception e) {

      log.error("{}", e.getLocalizedMessage());
    }

  }

}
