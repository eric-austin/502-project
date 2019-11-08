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
	
	//electricity supply policies (24)
	static public Policy BanCoal = new Policy("Boolean Ban New Power Plants[hard coal es]", bool, 0.0, 1.0);
	static public Policy BanNatGas = new Policy("Boolean Ban New Power Plants[natural gas nonpeaker es]", bool, 0.0, 1.0);
	static public Policy BanNuclear = new Policy("Boolean Ban New Power Plants[nuclear es]", bool, 0.0, 1.0);
	static public Policy BanHydro = new Policy("Boolean Ban New Power Plants[hydro es]", bool, 0.0, 1.0);
	static public Policy ChangeElecExp = new Policy("Percent Change in Electricity Exports", real, -0.5, 1.0);
	static public Policy ChangeElecImp = new Policy("Percent Change in Electricity Imports", real, -0.5, 1.0);
	static public Policy EarlyRetireCoal = new Policy("Annual Additional Capacity Retired due to Early Retirement Policy[hard coal es]", natural, 0, 2000);
	static public Policy IncreaseTransmission = new Policy("Percentage Increase in Transmission Capacity vs BAU", real, 0.0, 1.0);
	static public Policy RenewDevAndCoalToGas = new Policy("Boolean Use Non BAU Mandated Capacity Construction Schedule", bool, 0.0, 1.0);
	static public Policy NuclearLifeExt = new Policy("Nuclear Capacity Lifetime Extension", natural, 0, 20);
	static public Policy ReduceDowntimeGas = new Policy("Percentage Reduction in Plant Downtime[natural gas nonpeaker es,preexisting retiring]", real, 0.0, 0.6);
	static public Policy ReduceDowntimeOnWind = new Policy("Percentage Reduction in Plant Downtime[onshore wind es,newly built]", real, 0.0, 0.25);
	static public Policy ReduceDowntimeSolar = new Policy("Percentage Reduction in Plant Downtime[solar pv es,newly built]", real, 0.0, 0.30);
	static public Policy ReduceDowntimeOffWind = new Policy("Percentage Reduction in Plant Downtime[offshore wind es,newly built]", real, 0.0, 0.25);
	static public Policy ReduceCostOnWind = new Policy("Percent Reduction in Soft Costs of Capacity Construction[onshore wind es]", real, 0.0, 0.9);
	static public Policy ReduceCostSolar = new Policy("Percent Reduction in Soft Costs of Capacity Construction[solar pv es]", real, 0.0, 0.9);
	static public Policy ReduceCostOffWind = new Policy("Percent Reduction in Soft Costs of Capacity Construction[offshore wind es]", real, 0.0, 0.9);
	static public Policy ReduceTnDLosses = new Policy("Percentage TnD Losses Avoided", real, 0.0, 0.6);
	static public Policy RenewPortStnd = new Policy("Additional Renewable Portfolio Std Percentage", real, 0.0, 0.8);
	static public Policy SubsidyOnWind = new Policy("Subsidy for Elec Production by Fuel[onshore wind es]", natural, 0, 60);
	static public Policy SubsidySolarPV = new Policy("Subsidy for Elec Production by Fuel[solar pv es]", natural, 0, 60);
	static public Policy SubsidySolarTherm = new Policy("Subsidy for Elec Production by Fuel[solar thermal es]", natural, 0, 60);
	static public Policy SubsidyBio = new Policy("Subsidy for Elec Production by Fuel[biomass es]", natural, 0, 60);
	static public Policy SubsidyGeo = new Policy("Subsidy for Elec Production by Fuel[geothermal es]", natural, 0, 60);
	
	//industry policies (18)
	static public Policy CementSubst = new Policy("Fraction of Cement Clinker Substitution Made", real, 0.0, 1.0);
	static public Policy CogenWasteHeat = new Policy("Fraction of Potential Cogeneration and Waste Heat Recovery Adopted", real, 0.0, 1.0);
	static public Policy EarlyRetireIndustry = new Policy("Fraction of Energy Savings from Early Facility Retirement Achieved", real, 0.0, 1.0);
	static public Policy EfficiencyCement = new Policy("Percentage Improvement in Eqpt Efficiency Standards above BAU[cement and other carbonates]", real, 0.0, 0.33);
	static public Policy EfficiencyNatGasPetr = new Policy("Percentage Improvement in Eqpt Efficiency Standards above BAU[natural gas and petroleum systems]", real, 0.0, 0.33);
	static public Policy EfficiencyIron = new Policy("Percentage Improvement in Eqpt Efficiency Standards above BAU[iron and steel]", real, 0.0, 0.33);
	static public Policy EfficiencyChem = new Policy("Percentage Improvement in Eqpt Efficiency Standards above BAU[chemicals]", real, 0.0, 0.33);
	static public Policy EfficiencyMining = new Policy("Percentage Improvement in Eqpt Efficiency Standards above BAU[mining]", real, 0.0, 0.33);
	static public Policy EfficiencyWaste = new Policy("Percentage Improvement in Eqpt Efficiency Standards above BAU[waste management]", real, 0.0, 0.33);
	static public Policy EfficiencyAg = new Policy("Percentage Improvement in Eqpt Efficiency Standards above BAU[agriculture]", real, 0.0, 0.33);
	static public Policy EfficiencyOther = new Policy("Percentage Improvement in Eqpt Efficiency Standards above BAU[other industries]", real, 0.0, 0.33);
	static public Policy LimitOilsands = new Policy("Fraction of Installation and System Integration Issues Remedied", bool, 0.0, 1.0);
	static public Policy CoalToNatGas = new Policy("Fraction of Hard Coal Use Converted to Other Fuels", real, 0.0, 1.0);
	static public Policy NatGasToElec = new Policy("Fraction of Natural Gas Use Converted to Other Fuels", real, 0.0, 0.5);
	static public Policy MethaneCapt = new Policy("Fraction of Methane Capture Opportunities Achieved", real, 0.0, 1.0);
	static public Policy MethaneDestr = new Policy("Fraction of Methane Destruction Opportunities Achieved", real, 0.0, 1.0);
	static public Policy ReduceFGas = new Policy("Fraction of F Gases Avoided", real, 0.0, 1.0);
	static public Policy WorkerTraining = new Policy("Fraction of Addressable Process Emissions Avoided via Worker Training", real, 0.0, 1.0);
	
	//agriculture, land use, and forestry policies (6)
	static public Policy AnReForest = new Policy("Fraction of Afforestation and Reforestation Achieved", real, 0.0, 1.0);
	static public Policy DeForest = new Policy("Fraction of Avoided Deforestation Achieved", real, 0.0, 1.0);
	static public Policy ForestSetAsides = new Policy("Fraction of Forest Set Asides Achieved", real, 0.0, 1.0);
	static public Policy CroplandMgmt = new Policy("Fraction of Abatement from Cropland Management Achieved", real, 0.0, 1.0);
	static public Policy ForestMgmt = new Policy("Fraction of Improved Forest Management Achieved", real, 0.0, 1.0);
	static public Policy LivestockMeasures = new Policy("Fraction of Abatement from Livestock Measures Achieved", real, 0.0, 1.0);
	
	//cross-sector policies (16)
	static public Policy CarbonCapture = new Policy("Fraction of Potential Additional CCS Achieved", real, 0.0, 1.0);
	static public Policy CTaxTransport = new Policy("Carbon Tax[transportation sector]", natural, 0, 350);
	static public Policy CTaxElectr = new Policy("Carbon Tax[electricity sector]", natural, 0, 350);
	static public Policy CTaxResidential = new Policy("Carbon Tax[residential buildings sector]", natural, 0, 350);
	static public Policy CTaxCommercial = new Policy("Carbon Tax[commercial buildings sector]", natural, 0, 350);
	static public Policy CTaxIndustry = new Policy("Carbon Tax[industry sector]", natural, 0, 350);
	static public Policy EndSubsCoal = new Policy("Percent Reduction in BAU Subsidies[hard coal]", real, 0.0, 1.0);
	static public Policy EndSubsNatGas = new Policy("Percent Reduction in BAU Subsidies[natural gas]", real, 0.0, 1.0);
	static public Policy EndSubsGasoline = new Policy("Percent Reduction in BAU Subsidies[petroleum gasoline]", real, 0.0, 1.0);
	static public Policy EndSubsDiesel = new Policy("Percent Reduction in BAU Subsidies[petroleum diesel]", real, 0.0, 1.0);
	static public Policy EndSubsJetFuel = new Policy("Percent Reduction in BAU Subsidies[jet fuel]", real, 0.0, 1.0);
	static public Policy FuelTaxElectr = new Policy("Additional Fuel Tax Rate by Fuel[electricity]", real, 0.0, 0.4);
	static public Policy FuelTaxCoal = new Policy("Additional Fuel Tax Rate by Fuel[hard coal]", real, 0.0, 0.4);
	static public Policy FuelTaxNatGas = new Policy("Additional Fuel Tax Rate by Fuel[natural gas]", real, 0.0, 0.4);
	static public Policy FuelTaxGasoline = new Policy("Additional Fuel Tax Rate by Fuel[petroleum gasoline]", real, 0.0, 0.4);
	static public Policy FuelTaxDiesel = new Policy("Additional Fuel Tax Rate by Fuel[petroleum diesel]", real, 0.0, 0.4);
	
	//R&D policies
	static public Policy CCRHeat = new Policy("RnD Building Capital Cost Perc Reduction[heating]", real, 0.0, 0.4);
	static public Policy CCRCool = new Policy("RnD Building Capital Cost Perc Reduction[cooling and ventilation]", real, 0.0, 0.4);
	static public Policy CCREnvelope = new Policy("RnD Building Capital Cost Perc Reduction[envelope]", real, 0.0, 0.4);
	static public Policy CCRLighting = new Policy("RnD Building Capital Cost Perc Reduction[lighting]", real, 0.0, 0.4);
	static public Policy CCRApp = new Policy("RnD Building Capital Cost Perc Reduction[appliances]", real, 0.0, 0.4);
	static public Policy CCROther = new Policy("RnD Building Capital Cost Perc Reduction[other component]", real, 0.0, 0.4);
	static public Policy CCRCCS = new Policy("RnD CCS Capital Cost Perc Reduction", real, 0.0, 0.4);
	static public Policy CCRCoal = new Policy("RnD Electricity Capital Cost Perc Reduction[hard coal es]", real, 0.0, 0.4);
	static public Policy CCRNatGas = new Policy("RnD Electricity Capital Cost Perc Reduction[natural gas nonpeaker es]", real, 0.0, 0.4);
	static public Policy CCRNuclear = new Policy("RnD Electricity Capital Cost Perc Reduction[nuclear es]", real, 0.0, 0.4);
	static public Policy CCRHydro = new Policy("RnD Electricity Capital Cost Perc Reduction[hydro es]", real, 0.0, 0.4);
	static public Policy CCROnWind = new Policy("RnD Electricity Capital Cost Perc Reduction[onshore wind es]", real, 0.0, 0.4);
	static public Policy CCRSolarPV = new Policy("RnD Electricity Capital Cost Perc Reduction[solar pv es]", real, 0.0, 0.4);
	static public Policy CCRSolarTherm = new Policy("RnD Electricity Capital Cost Perc Reduction[solar thermal es]", real, 0.0, 0.4);
	static public Policy CCRBiomass = new Policy("RnD Electricity Capital Cost Perc Reduction[biomass es]", real, 0.0, 0.4);
	static public Policy CCRNatGasPeak = new Policy("RnD Electricity Capital Cost Perc Reduction[natural gas peaker es]", real, 0.0, 0.4);
	static public Policy CCROffWind = new Policy("RnD Electricity Capital Cost Perc Reduction[offshore wind es]", real, 0.0, 0.4);
	static public Policy CCRCement = new Policy("RnD Industry Capital Cost Perc Reduction[cement and other carbonates]", real, 0.0, 0.4);
	static public Policy CCRNatGasPetr = new Policy("RnD Industry Capital Cost Perc Reduction[natural gas and petroleum systems]", real, 0.0, 0.4);
	static public Policy CCRIronSteel = new Policy("RnD Industry Capital Cost Perc Reduction[iron and steel]", real, 0.0, 0.4);
	static public Policy CCRChem = new Policy("RnD Industry Capital Cost Perc Reduction[chemicals]", real, 0.0, 0.4);
	static public Policy CCRMining = new Policy("RnD Industry Capital Cost Perc Reduction[mining]", real, 0.0, 0.4);
	static public Policy CCRWaste = new Policy("RnD Industry Capital Cost Perc Reduction[waste management]", real, 0.0, 0.4);
	static public Policy CCRAg = new Policy("RnD Industry Capital Cost Perc Reduction[agriculture]", real, 0.0, 0.4);
	static public Policy CCROtherInd = new Policy("RnD Industry Capital Cost Perc Reduction[other industries]", real, 0.0, 0.4);
	
	
	//vector of all policies to be referenced by candidate solutions
	static public Policy[] allPolicies = {PollutionLDVs, PollutionHDVs, PollutionAircraft, PollutionRail, PollutionShips, PollutionMtrbks, EVPerks, 
			Feebate, EVSalesPassengerLDVs, EVSalesFreightLDVs, EVSalesPassengerHDVs, EVSalesFreightHDVs, EVSalesPassengerMtrbks,EVSubsidyPassengerLDVs, 
			EVSubsidyFreightHDVs, FuelEconLDVs, FuelEconHDVs, FuelEconAircraft, FuelEconRail, FuelEconShips, FuelEconMtrbks, PsgrTDM, FrgtTDM, LCFS,
			BuildingElecUrban, BuildingElecRural, BuildingElecComm, BuildingEffUrbHeat, BuildingEffUrbCool, BuildingEffUrbEnv, BuildingEffUrbLight,
			BuildingEffUrbApp, BuildingEffUrbOther, BuildingEffRurHeat, BuildingEffRurCool, BuildingEffRurEnv, BuildingEffRurLight, BuildingEffRurApp,
			BuildingEffRurOther, BuildingEffCommHeat, BuildingEffCommCool, BuildingEffCommEnv, BuildingEffCommLight, BuildingEffCommApp, BuildingEffCommOther,
			ContrTraining, SolarCarveOut, SolarSubsidy, ImprovedLabel, RetroHeat, RetroCool, RetroEnv, RetroLight, RetroApp, RetroOther, RebateHeat,
			RebateCool, RebateEnv, RebateLight, RebateApp, BanCoal, BanNatGas, BanNuclear, BanHydro, ChangeElecExp, ChangeElecImp, EarlyRetireCoal,
			IncreaseTransmission, RenewDevAndCoalToGas, NuclearLifeExt, ReduceDowntimeGas, ReduceDowntimeOnWind, ReduceDowntimeSolar, ReduceDowntimeOffWind,
			ReduceCostOnWind, ReduceCostSolar, ReduceCostOffWind, ReduceTnDLosses, RenewPortStnd, SubsidyOnWind, SubsidySolarPV, SubsidySolarTherm, SubsidyBio, 
			SubsidyGeo, CementSubst, CogenWasteHeat, EarlyRetireIndustry, EfficiencyCement, EfficiencyNatGasPetr, EfficiencyIron, EfficiencyChem,
			EfficiencyMining, EfficiencyWaste, EfficiencyAg, EfficiencyOther, LimitOilsands, CoalToNatGas, NatGasToElec, MethaneCapt, MethaneDestr,
			ReduceFGas, WorkerTraining, AnReForest, DeForest, ForestSetAsides, CroplandMgmt, ForestMgmt, LivestockMeasures, CarbonCapture, CTaxTransport,
			CTaxElectr, CTaxResidential, CTaxCommercial, CTaxIndustry, EndSubsCoal, EndSubsNatGas, EndSubsGasoline, EndSubsDiesel, EndSubsJetFuel,
			FuelTaxElectr, FuelTaxCoal, FuelTaxNatGas, FuelTaxGasoline, FuelTaxDiesel, CCRHeat, CCRCool, CCREnvelope, CCRLighting, CCRApp, CCROther, CCRCCS,
			CCRCoal, CCRNatGas, CCRNuclear, CCRHydro, CCROnWind, CCRSolarPV, CCRSolarTherm, CCRBiomass, CCRNatGasPeak, CCROffWind, CCRCement, CCRNatGasPetr,
			CCRIronSteel, CCRChem, CCRMining, CCRWaste, CCRAg, CCROtherInd};
}
