/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.identity.data.rmnch;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

/**
 * 
 * @author DU20091017
 *
 */

@Entity
@Table(name = "i_cbacdetails")
@Data
public class RMNCHCBACdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "CBACDetailsid", insertable = false, updatable = false)
	private Long cBACDetailsid;

	@Expose
	@Column(name = "BeneficiaryRegId")
	private Long BenRegId;

	@Expose
	@Column(name = "cbac_age")
	private String cbac_age;

	@Expose
	@Column(name = "cbac_age_posi")
	private Integer cbac_age_posi;

	@Expose
	@Column(name = "cbac_alcohol")
	private String cbac_alcohol;

	@Expose
	@Column(name = "cbac_alcohol_posi")
	private Integer cbac_alcohol_posi;

	@Expose
	@Column(name = "cbac_antitbdrugs")
	private String cbac_antitbdrugs;

	@Expose
	@Column(name = "cbac_antitbdrugs_pos")
	private Integer cbac_antitbdrugs_pos;

	@Expose
	@Column(name = "cbac_bleedingafterintercourse")
	private String cbac_bleedingafterintercourse;

	@Expose
	@Column(name = "cbac_bleedingafterintercourse_pos")
	private Integer cbac_bleedingafterintercourse_pos;

	@Expose
	@Column(name = "cbac_bleedingaftermenopause")
	private String cbac_bleedingaftermenopause;

	@Expose
	@Column(name = "cbac_bleedingaftermenopause_pos")
	private Integer cbac_bleedingaftermenopause_pos;

	@Expose
	@Column(name = "cbac_bleedingbtwnperiods")
	private String cbac_bleedingbtwnperiods;

	@Expose
	@Column(name = "cbac_bleedingbtwnperiods_pos")
	private Integer cbac_bleedingbtwnperiods_pos;

	@Expose
	@Column(name = "cbac_blooddischage")
	private String cbac_blooddischage;

	@Expose
	@Column(name = "cbac_blooddischage_pos")
	private Integer cbac_blooddischage_pos;

	@Expose
	@Column(name = "cbac_bloodsputum")
	private String cbac_bloodsputum;

	@Expose
	@Column(name = "cbac_bloodsputum_pos")
	private Integer cbac_bloodsputum_pos;

	@Expose
	@Column(name = "cbac_changeinbreast")
	private String cbac_changeinbreast;

	@Expose
	@Column(name = "cbac_changeinbreast_pos")
	private Integer cbac_changeinbreast_pos;

	@Expose
	@Column(name = "cbac_coughing")
	private String cbac_coughing;

	@Expose
	@Column(name = "cbac_coughing_pos")
	private Integer cbac_coughing_pos;

	@Expose
	@Column(name = "cbac_difficultyinmouth")
	private String cbac_difficultyinmouth;

	@Expose
	@Column(name = "cbac_difficultyinmouth_pos")
	private Integer cbac_difficultyinmouth_pos;

	@Expose
	@Column(name = "cbac_familyhistory")
	private String cbac_familyhistory;

	@Expose
	@Column(name = "cbac_familyhistory_posi")
	private Integer cbac_familyhistory_posi;

	@Expose
	@Column(name = "cbac_fivermore")
	private String cbac_fivermore;

	@Expose
	@Column(name = "cbac_fivermore_pos")
	private Integer cbac_fivermore_pos;

	@Expose
	@Column(name = "cbac_foulveginaldischarge")
	private String cbac_foulveginaldischarge;

	@Expose
	@Column(name = "cbac_foulveginaldischarge_pos")
	private Integer cbac_foulveginaldischarge_pos;

	@Expose
	@Column(name = "cbac_historyoffits")
	private String cbac_historyoffits;

	@Expose
	@Column(name = "cbac_historyoffits_pos")
	private Integer cbac_historyoffits_pos;

	@Expose
	@Column(name = "cbac_loseofweight")
	private String cbac_loseofweight;

	@Expose
	@Column(name = "cbac_loseofweight_pos")
	private Integer cbac_loseofweight_pos;

	@Expose
	@Column(name = "cbac_lumpinbreast")
	private String cbac_lumpinbreast;

	@Expose
	@Column(name = "cbac_lumpinbreast_pos")
	private Integer cbac_lumpinbreast_pos;

	@Expose
	@Column(name = "cbac_nightsweats")
	private String cbac_nightsweats;

	@Expose
	@Column(name = "cbac_nightsweats_pos")
	private Integer cbac_nightsweats_pos;

	@Expose
	@Column(name = "cbac_pa")
	private String cbac_pa;

	@Expose
	@Column(name = "cbac_pa_posi")
	private Integer cbac_pa_posi;

	@Expose
	@Column(name = "cbac_referpatient_mo")
	private Integer cbac_referpatient_mo;

	@Expose
	@Column(name = "cbac_smoke")
	private String cbac_smoke;

	@Expose
	@Column(name = "cbac_smoke_posi")
	private Integer cbac_smoke_posi;

	@Expose
	@Column(name = "cbac_sortnesofbirth")
	private String cbac_sortnesofbirth;

	@Expose
	@Column(name = "cbac_sortnesofbirth_pos")
	private Integer cbac_sortnesofbirth_pos;

	@Expose
	@Column(name = "cbac_sputemcollection")
	private Integer cbac_sputemcollection;

	@Expose
	@Column(name = "cbac_sufferingtb")
	private String cbac_sufferingtb;

	@Expose
	@Column(name = "cbac_sufferingtb_pos")
	private Integer cbac_sufferingtb_pos;

	@Expose
	@Column(name = "cbac_tbhistory")
	private String cbac_tbhistory;

	@Expose
	@Column(name = "cbac_tbhistory_pos")
	private Integer cbac_tbhistory_pos;

	@Expose
	@Column(name = "cbac_toneofvoice")
	private String cbac_toneofvoice;

	@Expose
	@Column(name = "cbac_toneofvoice_pos")
	private Integer cbac_toneofvoice_pos;

	@Expose
	@Column(name = "cbac_tracing_all_fm")
	private String cbac_tracing_all_fm;

	@Expose
	@Column(name = "cbac_uicers")
	private String cbac_uicers;

	@Expose
	@Column(name = "cbac_uicers_pos")
	private Integer cbac_uicers_pos;

	@Expose
	@Column(name = "cbac_waist")
	private String cbac_waist;

	@Expose
	@Column(name = "cbac_waist_posi")
	private Integer cbac_waist_posi;

	@Expose
	@Column(name = "houseoldId")
	private Long houseoldId;

	@Expose
	@Column(name = "countryid")
	private Integer Countyid;

	@Expose
	@Column(name = "stateid")
	private Integer stateid;

	@Expose
	@Column(name = "districtid")
	private Integer districtid;

	@Expose
	@Column(name = "districtname")
	private String districtname;

	@Expose
	@Column(name = "villageid")
	private Integer villageid;

	@Expose
	@Column(name = "serverUpdatedStatus")
	private Integer serverUpdatedStatus;

	@Expose
	@Column(name = "total_score")
	private Integer total_score;

	@Expose
	@Column(name = "Deleted")
	private Boolean Deleted;

	@Expose
	@Column(name = "Processed")
	private String Processed = "N";

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "Reserved")
	private Boolean reserved;

	@Expose
	@Column(name = "ReservedFor")
	private String reservedFor;

	@Expose
	@Column(name = "ReservedOn")
	private String reservedOn;

	@Expose
	@Column(name = "ReservedByid")
	private Integer reservedByid;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Expose
	@Column(name = "VanSerialNo")
	private Long id;

	@Expose
	@Column(name = "vanID")
	private Integer VanID;

	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;

	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;

	@Expose
	@Column(name = "SyncedBy")
	private String syncedBy;

	@Expose
	@Column(name = "SyncedDate")
	private Timestamp syncedDate;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer ProviderServiceMapID;

	@Expose
	@Column(name = "deviceId")
	private Integer deviceId;

	@Expose
	@Column(name = "beneficiaryId")
	private Long benficieryid;

	// new fields, 16-09-2021
	@Expose
	@Column(name = "cbac_Pain_while_chewing")
	private String cbac_Pain_while_chewing;
	@Expose
	@Column(name = "cbac_Pain_while_chewing_posi")
	private Integer cbac_Pain_while_chewing_posi;
	@Expose
	@Column(name = "cbac_any_thickend_skin")
	private String cbac_any_thickend_skin;
	@Expose
	@Column(name = "cbac_any_thickend_skin_posi")
	private Integer cbac_any_thickend_skin_posi;
	@Expose
	@Column(name = "cbac_clawing_of_fingers")
	private String cbac_clawing_of_fingers;
	@Expose
	@Column(name = "cbac_clawing_of_fingers_posi")
	private Integer cbac_clawing_of_fingers_posi;
	@Expose
	@Column(name = "cbac_diff_holding_obj")
	private String cbac_diff_holding_obj;
	@Expose
	@Column(name = "cbac_diff_holding_obj_posi")
	private Integer cbac_diff_holding_obj_posi;
	@Expose
	@Column(name = "cbac_feeling_down")
	private String cbac_feeling_down;
	@Expose
	@Column(name = "cbac_feeling_down_posi")
	private Integer cbac_feeling_down_posi;
	@Expose
	@Column(name = "cbac_feeling_down_score")
	private Integer cbac_feeling_down_score;
	@Expose
	@Column(name = "cbac_fuel_used")
	private String cbac_fuel_used;
	@Expose
	@Column(name = "cbac_fuel_used_posi")
	private Integer cbac_fuel_used_posi;
	@Expose
	@Column(name = "cbac_growth_in_mouth")
	private String cbac_growth_in_mouth;
	@Expose
	@Column(name = "cbac_growth_in_mouth_posi")
	private Integer cbac_growth_in_mouth_posi;
	@Expose
	@Column(name = "cbac_hyper_pigmented_patch")
	private String cbac_hyper_pigmented_patch;
	@Expose
	@Column(name = "cbac_hyper_pigmented_patch_posi")
	private Integer cbac_hyper_pigmented_patch_posi;
	@Expose
	@Column(name = "cbac_inability_close_eyelid")
	private String cbac_inability_close_eyelid;
	@Expose
	@Column(name = "cbac_inability_close_eyelid_posi")
	private Integer cbac_inability_close_eyelid_posi;
	@Expose
	@Column(name = "cbac_little_interest")
	private String cbac_little_interest;
	@Expose
	@Column(name = "cbac_little_interest_posi")
	private Integer cbac_little_interest_posi;
	@Expose
	@Column(name = "cbac_little_interest_score")
	private Integer cbac_little_interest_score;
	@Expose
	@Column(name = "cbac_nodules_on_skin")
	private String cbac_nodules_on_skin;
	@Expose
	@Column(name = "cbac_nodules_on_skin_posi")
	private Integer cbac_nodules_on_skin_posi;
	@Expose
	@Column(name = "cbac_numbness_on_palm")
	private String cbac_numbness_on_palm;
	@Expose
	@Column(name = "cbac_numbness_on_palm_posi")
	private Integer cbac_numbness_on_palm_posi;
	@Expose
	@Column(name = "cbac_occupational_exposure")
	private String cbac_occupational_exposure;
	@Expose
	@Column(name = "cbac_occupational_exposure_posi")
	private Integer cbac_occupational_exposure_posi;
	@Expose
	@Column(name = "cbac_tingling_or_numbness")
	private String cbac_tingling_or_numbness;
	@Expose
	@Column(name = "cbac_tingling_or_numbness_posi")
	private Integer cbac_tingling_or_numbness_posi;
	@Expose
	@Column(name = "cbac_weekness_in_feet")
	private String cbac_weekness_in_feet;
	@Expose
	@Column(name = "cbac_weekness_in_feet_posi")
	private Integer cbac_weekness_in_feet_posi;
	@Expose
	@Column(name = "suspected_hrp")
	private String suspected_hrp;
	@Expose
	@Column(name = "suspected_ncd")
	private String suspected_ncd;
	@Expose
	@Column(name = "suspected_tb")
	private String suspected_tb;
	@Expose
	@Column(name = "suspected_ncd_diseases")
	private String suspected_ncd_diseases;
	
	
	
	@Expose
	@Column(name = "confirmed_hrp")
	private String confirmed_hrp;
	@Expose
	@Column(name = "confirmed_ncd")
	private String confirmed_ncd;
	@Expose
	@Column(name = "confirmed_tb")
	private String confirmed_tb;
	@Expose
	@Column(name = "confirmed_ncd_diseases")
	private String confirmed_ncd_diseases;
	
	@Expose
	@Column(name = "diagnosis_status")
	private String diagnosis_status;
	

}
