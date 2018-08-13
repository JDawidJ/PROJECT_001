package app.dto.mappers;

import app.dto.*;
import app.model.*;

import java.util.HashSet;

public class ModelMapper {
    public CountryDTO fromCountryToCountryDTO(Country country) {
        return country == null ? null : CountryDTO.builder()
                .id(country.getId())
                .name(country.getName())
                .capitol(country.getCapitol())
                .build();
    }

    public Country fromCountryDTOToCountry(CountryDTO countryDTO) {
        return countryDTO == null ? null : Country.builder()
                .id(countryDTO.getId())
                .name(countryDTO.getName())
                .capitol(countryDTO.getCapitol())
                .companies(new HashSet<>())
                .managers(new HashSet<>())
                .players(new HashSet<>())
                .teams(new HashSet<>())
                .build();
    }

    public CompanyDTO fromCompanyTOCompanyDTO(Company company) {
        return company == null ? null : CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .budget(company.getBudget())
                .countryDTO(company.getCountry() == null ? null : fromCountryToCountryDTO(company.getCountry()))
                .build();
    }

    public Company fromCompanyDTOTOCompany(CompanyDTO companyDTO) { //!!
        return companyDTO == null ? null : Company.builder()
                .id(companyDTO.getId())
                .name(companyDTO.getName())
                .budget(companyDTO.getBudget())
                .country(companyDTO.getCountryDTO() == null ? null : fromCountryDTOToCountry(companyDTO.getCountryDTO()))
                .build();
    }

    public TeamDTO fromTeamToTeamDTO(Team team) {
        return team == null ? null : TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .countryDTO(team.getCountry() == null ? null : fromCountryToCountryDTO(team.getCountry()))
                .managerDTO(team.getManager() == null ? null : fromManagerToManagerDTO(team.getManager()))
                .stadiumDTO(team.getStadium() == null ? null : fromStadiumToStadiumDTO(team.getStadium()))
                .position(team.getPosition())
                .build();


    }

    public Team fromTeamDTOToTeam(TeamDTO teamDTO) {
        return teamDTO == null ? null : Team.builder()
                .id(teamDTO.getId())
                .name(teamDTO.getName())
                .position(teamDTO.getPosition())
                .contracts(new HashSet<>())
                .players(new HashSet<>())
                .country(teamDTO.getCountryDTO() == null ? null : fromCountryDTOToCountry(teamDTO.getCountryDTO()))
                .manager(teamDTO.getManagerDTO() == null ? null : fromManagerDTOToMangaer(teamDTO.getManagerDTO()))
                .stadium(teamDTO.getStadiumDTO() == null ? null : fromStadiumDTOToStadium(teamDTO.getStadiumDTO()))
                .build();
    }

    public StadiumDTO fromStadiumToStadiumDTO(Stadium stadium) {
        return stadium == null ? null : StadiumDTO.builder()
                .id(stadium.getId())
                .capacity(stadium.getCapacity())
                .name(stadium.getName())
                .build();
    }

    public Stadium fromStadiumDTOToStadium(StadiumDTO stadiumDTO) {
        return stadiumDTO == null ? null : Stadium.builder()
                .id(stadiumDTO.getId())
                .capacity(stadiumDTO.getCapacity())
                .name(stadiumDTO.getName())
                .teams(new HashSet<>())
                .build();
    }

    public CompanyDTO fromCompanyToCompanyDTO(Company company) {
        return company == null ? null : CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .budget(company.getBudget())
                .countryDTO(company.getCountry() == null ? null : fromCountryToCountryDTO(company.getCountry()))
                .build();
    }

    public Company fromCompanyDTOToCompany(CompanyDTO companyDTO) {
        return companyDTO == null ? null : Company.builder()
                .id(companyDTO.getId())
                .name(companyDTO.getName())
                .budget(companyDTO.getBudget())
                .country(companyDTO.getCountryDTO() == null ? null : fromCountryDTOToCountry(companyDTO.getCountryDTO()))
                .contracts(new HashSet<>())
                .build();
    }

    public PlayerDTO fromPlayerToPlayerDTO(Player player) {
        return player == null ? null : PlayerDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .surname(player.getSurname())
                .goals(player.getGoals())
                .countryDTO(player.getCountry() == null ? null : fromCountryToCountryDTO(player.getCountry()))
                .healthCardDTO(player.getHealthCard() == null ? null : fromHelthCardToHelthCardDTO(player.getHealthCard()))
                .positionDTO(player.getPosition() == null ? null : fromPositionToPositionDTO(player.getPosition()))
                .teamDTO(player.getTeam() == null ? null : fromTeamToTeamDTO(player.getTeam()))
                .build();

    }

    public Player fromPlayerDTOToPlayer(PlayerDTO playerDTO) {
        return playerDTO == null ? null : Player.builder()
                .id(playerDTO.getId())
                .name(playerDTO.getName())
                .surname(playerDTO.getSurname())
                .goals(playerDTO.getGoals())
                .cards(new HashSet<>())
                .country(playerDTO.getCountryDTO() == null ? null : fromCountryDTOToCountry(playerDTO.getCountryDTO()))
                .healthCard(playerDTO.getHealthCardDTO() == null ? null : ftromHelthCardDTOToHelthCard(playerDTO.getHealthCardDTO()))
                .position(playerDTO.getPositionDTO() == null ? null : fromPositionDTOToPosition(playerDTO.getPositionDTO()))
                .build();

    }

    public PositionDTO fromPositionToPositionDTO(Position position) {
        return position == null ? null : PositionDTO.builder()
                .id(position.getId())
                .name(position.getName())
                .build();
    }

    public Position fromPositionDTOToPosition(PositionDTO positionDTO) {
        return positionDTO == null ? null : Position.builder()
                .id(positionDTO.getId())
                .name(positionDTO.getName())
                .players(new HashSet<>())
                .build();
    }

    public HealthCardDTO fromHelthCardToHelthCardDTO(HealthCard healthCard) {
        return healthCard == null ? null : HealthCardDTO.builder()
                .id(healthCard.getId())
                .examDate(healthCard.getExamDate())
                .injuries(new HashSet<>())
                .playerDTO(healthCard.getPlayer() == null ? null : fromPlayerToPlayerDTO(healthCard.getPlayer()))
                .build();
    }

    public HealthCard ftromHelthCardDTOToHelthCard(HealthCardDTO healthCardDTO) {
        return healthCardDTO == null ? null : HealthCard.builder()
                .id(healthCardDTO.getId())
                .examDate(healthCardDTO.getExamDate())
                .injuries(new HashSet<>())
                .player(healthCardDTO.getPlayerDTO() == null ? null : fromPlayerDTOToPlayer(healthCardDTO.getPlayerDTO()))
                .build();
    }

    public Manager fromManagerDTOToMangaer(ManagerDTO managerDTO) {
        return managerDTO == null ? null : Manager.builder()
                .id(managerDTO.getId())
                .age(managerDTO.getAge())
                .country(managerDTO.getCountryDTO() == null ? null : fromCountryDTOToCountry(managerDTO.getCountryDTO()))
                .name(managerDTO.getName())
                .surname(managerDTO.getSurname())
                .build();
    }

    public ManagerDTO fromManagerToManagerDTO(Manager manager) {
        return manager == null ? null : ManagerDTO.builder()
                .id(manager.getId())
                .age(manager.getAge())
                .name(manager.getName())
                .surname(manager.getSurname())
                .countryDTO(manager.getCountry() == null ? null : fromCountryToCountryDTO(manager.getCountry()))
                .build();

    }
}
