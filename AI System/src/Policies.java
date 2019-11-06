/**
 * Class representing the policies of the EPS
 *
 */
public class Policies {
	//instance variables
	static public int bool = 0;
	static public int natural = 1;
	static public int real = 2;
	
	
	//transportation sector policies (24)
	static public Policy PollutionLDVs = new Policy("Percentage Reduction of Separately Regulated Pollutants[LDVs]", real, 0.0, 1.0);
	static public Policy PollutionHDVs = new Policy("Percentage Reduction of Separately Regulated Pollutants[HDVs]", real, 0.0, 1.0);
	static public Policy PollutionAircraft = new Policy("Percentage Reduction of Separately Regulated Pollutants[aircraft]", real, 0.0, 1.0);
	static public Policy PollutionRail = new Policy("Percentage Reduction of Separately Regulated Pollutants[rail]", real, 0.0, 1.0);
	static public Policy PollutionShips = new Policy("Percentage Reduction of Separately Regulated Pollutants[ships]", real, 0.0, 1.0);
	static public Policy PollutionMtrbks = new Policy("Percentage Reduction of Separately Regulated Pollutants[motorbikes]", real, 0.0, 1.0);
	static public Policy EVPerks = new Policy("Boolean EV Perks", bool, 0.0, 1.0);
	static public Policy Feebate = new Policy("LDVs Feebate Rate", real, 0.0, 1.0);
	static public Policy EVSalesPassengerLDVs = new Policy("Additional Minimum Required EV Sales Percentage[passenger,LDVs]", real, 0.0, 1.0);
	static public Policy EVSalesFreightLDVs = new Policy("Additional Minimum Required EV Sales Percentage[freight,LDVs]", real, 0.0, 1.0);
	static public Policy EVSalesPassengerHDVs = new Policy("Additional Minimum Required EV Sales Percentage[passenger,HDVs]", real, 0.0, 1.0);
	static public Policy EVSalesFreightHDVs = new Policy("Additional Minimum Required EV Sales Percentage[freight,HDVs]", real, 0.0, 1.0);
	static public Policy EVSalesPassengerMtrbks = new Policy("Additional Minimum Required EV Sales Percentage[passenger,motorbikes]", real, 0.0, 1.0);
	static public Policy EVSubsidyPassengerLDVs = new Policy("Additional EV Subsidy Percentage[passenger,LDVs]", real, 0.0, 0.5);
	static public Policy EVSubsidyFreightHDVs = new Policy("Additional EV Subsidy Percentage[freight,HDVs]", real, 0.0, 0.5);
	static public Policy FuelEconLDVs = new Policy("Percentage Additional Improvement of Fuel Economy Std[gasoline vehicle,LDVs]", real, 0.0, 1.0);
	static public Policy FuelEconHDVs = new Policy("Percentage Additional Improvement of Fuel Economy Std[diesel vehicle,HDVs]", real, 0.0, 0.66);
	static public Policy FuelEconAircraft = new Policy("Percentage Additional Improvement of Fuel Economy Std[nonroad vehicle,aircraft]", real, 0.0, 0.54);
	static public Policy FuelEconRail = new Policy("Percentage Additional Improvement of Fuel Economy Std[nonroad vehicle,rail]", real, 0.0, 0.2);
	static public Policy FuelEconShips = new Policy("Percentage Additional Improvement of Fuel Economy Std[nonroad vehicle,ships]", real, 0.0, 0.2);
	static public Policy FuelEconMtrbks = new Policy("Percentage Additional Improvement of Fuel Economy Std[gasoline vehicle,motorbikes]", real, 0, 0.74);
	static public Policy PsgrTDM = new Policy("Fraction of TDM Package Implemented[passenger]", real, 0.0, 1.0);
	static public Policy FrgtTDM = new Policy("Fraction of TDM Package Implemented[freight]", real, 0.0, 1.0);
	static public Policy LCFS = new Policy("Additional LCFS Percentage", real, 0.0, 0.4);
	
	//building and appliances sector policies (36)
	static public Policy BuildingElecUrban = new Policy("Percent New Nonelec Component Sales Shifted to Elec[urban residential]", real, 0.0, 1.0);
	static public Policy BuildingElecRural = new Policy("Percent New Nonelec Component Sales Shifted to Elec[rural residential]", real, 0.0, 1.0);
	static public Policy BuildingElecComm = new Policy("Percent New Nonelec Component Sales Shifted to Elec[commercial]", real, 0.0, 1.0);
	
	static public Policy BuildingEffUrbHeat = new Policy("Reduction in E Use Allowed by Component Eff Std[heating,urban residential]", real, 0.0, 1.0);
	static public Policy BuildingEffUrbCool = new Policy("Reduction in E Use Allowed by Component Eff Std[cooling and ventilation,urban residential]", real, 0.0, 1.0);
	static public Policy BuildingEffUrbEnv = new Policy("Reduction in E Use Allowed by Component Eff Std[envelope,urban residential]", real, 0.0, 1.0);
	static public Policy BuildingEffUrbLight = new Policy("Reduction in E Use Allowed by Component Eff Std[lighting,urban residential]", real, 0.0, 1.0);
	static public Policy BuildingEffUrbApp = new Policy("Reduction in E Use Allowed by Component Eff Std[appliances,urban residential]", real, 0.0, 1.0);
	static public Policy BuildingEffUrbOther = new Policy("Reduction in E Use Allowed by Component Eff Std[other component,urban residential]", real, 0.0, 1.0);
	static public Policy BuildingEffRurHeat = new Policy("Reduction in E Use Allowed by Component Eff Std[heating,rural residential]", real, 0.0, 1.0);
	static public Policy BuildingEffRurCool = new Policy("Reduction in E Use Allowed by Component Eff Std[cooling and ventilation,rural residential]", real, 0.0, 1.0);
	static public Policy BuildingEffRurEnv = new Policy("Reduction in E Use Allowed by Component Eff Std[envelope,rural residential]", real, 0.0, 1.0);
	static public Policy BuildingEffRurLight = new Policy("Reduction in E Use Allowed by Component Eff Std[lighting,rural residential]", real, 0.0, 1.0);
	static public Policy BuildingEffRurApp = new Policy("Reduction in E Use Allowed by Component Eff Std[appliances,rural residential]", real, 0.0, 1.0);
	static public Policy BuildingEffRurOther = new Policy("Reduction in E Use Allowed by Component Eff Std[other component,rural residential", real, 0.0, 1.0);
	static public Policy BuildingEffCommHeat = new Policy("Reduction in E Use Allowed by Component Eff Std[heating,commercial]", real, 0.0, 1.0);
	static public Policy BuildingEffCommCool = new Policy("Reduction in E Use Allowed by Component Eff Std[cooling and ventilation,commercial]", real, 0.0, 1.0);
	static public Policy BuildingEffCommEnv = new Policy("Reduction in E Use Allowed by Component Eff Std[envelope,commercial]", real, 0.0, 1.0);
	static public Policy BuildingEffCommLight = new Policy("Reduction in E Use Allowed by Component Eff Std[lighting,commercial]", real, 0.0, 1.0);
	static public Policy BuildingEffCommApp = new Policy("Reduction in E Use Allowed by Component Eff Std[appliances,commercial]", real, 0.0, 1.0);
	static public Policy BuildingEffCommOther = new Policy("Reduction in E Use Allowed by Component Eff Std[other component,commercial]", real, 0.0, 1.0);
	
	static public Policy ContrTraining = new Policy("Boolean Improved Contractor Edu and Training", bool, 0.0, 1.0);
	
	static public Policy SolarCarveOut = new Policy("Min Fraction of Total Elec Demand to be Met by Distributed Solar PV", real, 0.0, 0.24);
	
	static public Policy SolarSubsidy = new Policy("Perc Subsidy for Distributed Solar PV Capacity", real, 0.0, 0.5);
	
	static public Policy ImprovedLabel = new Policy("Boolean Improved Device Labeling", bool, 0.0, 1.0);
	
	static public Policy RetroHeat = new Policy("Fraction of Commercial Components Replaced Annually due to Retrofitting Policy[heating]", real, 0.0, 0.034);
	static public Policy RetroCool = new Policy("Fraction of Commercial Components Replaced Annually due to Retrofitting Policy[cooling and ventilation]", real, 0.0, 0.034);
	static public Policy RetroEnv = new Policy("Fraction of Commercial Components Replaced Annually due to Retrofitting Policy[envelope]", real, 0.0, 0.034);
	static public Policy RetroLight = new Policy("Fraction of Commercial Components Replaced Annually due to Retrofitting Policy[lighting]", real, 0.0, 0.034);
	static public Policy RetroApp = new Policy("Fraction of Commercial Components Replaced Annually due to Retrofitting Policy[appliances]", real, 0.0, 0.034);
	static public Policy RetroOther = new Policy("Fraction of Commercial Components Replaced Annually due to Retrofitting Policy[other component]", real, 0.0, 0.034);
	
	static public Policy RebateHeat = new Policy("Boolean Rebate Program for Efficient Components[heating]", bool, 0.0, 1.0);
	static public Policy RebateCool = new Policy("Boolean Rebate Program for Efficient Components[cooling and ventilation]", bool, 0.0, 1.0);
	static public Policy RebateEnv = new Policy("Boolean Rebate Program for Efficient Components[envelope]", bool, 0.0, 1.0);
	static public Policy RebateLight = new Policy("Boolean Rebate Program for Efficient Components[lighting]", bool, 0.0, 1.0);
	static public Policy RebateApp = new Policy("Boolean Rebate Program for Efficient Components[appliances]", bool, 0.0, 1.0);
	
	//vector of all policies to be referenced by candidate solutions
	static public Policy[] allPolicies = {PollutionLDVs, PollutionHDVs, PollutionAircraft, PollutionRail, PollutionShips, PollutionMtrbks, EVPerks, 
			Feebate, EVSalesPassengerLDVs, EVSalesFreightLDVs, EVSalesPassengerHDVs, EVSalesFreightHDVs, EVSalesPassengerMtrbks,EVSubsidyPassengerLDVs, 
			EVSubsidyFreightHDVs, FuelEconLDVs, FuelEconHDVs, FuelEconAircraft, FuelEconRail, FuelEconShips, FuelEconMtrbks, PsgrTDM, FrgtTDM, LCFS,
			BuildingElecUrban, BuildingElecRural, BuildingElecComm, BuildingEffUrbHeat, BuildingEffUrbCool, BuildingEffUrbEnv, BuildingEffUrbLight,
			BuildingEffUrbApp, BuildingEffUrbOther, BuildingEffRurHeat, BuildingEffRurCool, BuildingEffRurEnv, BuildingEffRurLight, BuildingEffRurApp,
			BuildingEffRurOther, BuildingEffCommHeat, BuildingEffCommCool, BuildingEffCommEnv, BuildingEffCommLight, BuildingEffCommApp, BuildingEffCommOther,
			ContrTraining, SolarCarveOut, SolarSubsidy, ImprovedLabel, RetroHeat, RetroCool, RetroEnv, RetroLight, RetroApp, RetroOther, RebateHeat,
			RebateCool, RebateEnv, RebateLight, RebateApp};
}
