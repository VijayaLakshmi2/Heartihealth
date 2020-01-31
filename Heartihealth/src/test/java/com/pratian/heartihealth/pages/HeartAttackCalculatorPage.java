package com.pratian.heartihealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pratian.heartihealth.testlisteners.TestListener;

public class HeartAttackCalculatorPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//Identifying the location of Heart Attack Predictor Title
	By heartAttackPredictorTitle=By.id("heartAttackPredictorTitle");
	By ageTextBox=By.id("ageInput");
	
	By male=By.id("maleRadio");
	By female=By.id("femaleRadio");
	
	By chestPainYes=By.id("chestPainYesRadio");
	By chestPainNo=By.id("chestPainNoRadio");
	
	By bloodPressureTextBox=By.id("bloddPressureInput");
	
	By cholesterolLevelTextBox=By.id("cholesterolInput");
	
	By fastingBloodSugarLevelTextBox=By.id("fastingBloodSugarInput");
	
	By restECGPositive=By.id("restECGPositiveRadio");
	By restECGNegative=By.id("restECGNegativeRadio");
	
	By maximumHeartRateAchievedTextBox=By.id("heartRateInput");
	
	By exerciseIncludesAnginaYes=By.id("anginaYesRadio");
	By exerciseIncludesAnginaNo=By.id("anginaNoRadio");
	
	By depressionIncludedByExerciseTextBox=By.id("depressionInput");
	
	By slopeOfThePeekExerciseTextBox=By.id("peakExerciseInput");
	
	By vesselsColoredByFlouoroscopyTextBox=By.id("fluoroscopyInput");
	
	By thalassemiaLevelTextBox=By.id("thalassemiaInput");
	
	By calculateButton=By.id("heartPredictorCalculateBtn");
	
	public HeartAttackCalculatorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Boolean navigatedToHeartAttackPredictor() {
		Boolean flag=false;
		wait= new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(heartAttackPredictorTitle));
		//System.out.println(driver.findElement(heartAttackPredictorTitle).getText());
		if(driver.findElement(heartAttackPredictorTitle).getText().equalsIgnoreCase("Heart Attack Predictor")){
			TestListener.reportLog("Navigated to Heart Attack Calculator Page");
			flag=true;
		}
		else
			throw new RuntimeException("Home Page is not loaded");
		return flag;
		
	}
	
	public void calculateHeartAttack(String age,String gender,String doYouExperiencedchestPain,
			String bloodPressureLevel, String cholesterolLevel,String fastingBloodSugarLevel,String restECG,
			String maximumHeartRateAchieved,String exerciseIncludesAngina,String depressionIncludedByExercise,
			String slopeOfThePeekExercise,String vesselsColoredByFlouoroscopy, String thalassemiaLevel){
		wait= new WebDriverWait(driver,120);
		
		// enter age in text box
		wait.until(ExpectedConditions.visibilityOfElementLocated(ageTextBox)).click();
		driver.findElement(ageTextBox).clear();
		driver.findElement(ageTextBox).sendKeys(age);
		
		//Select gender male/female
		wait.until(ExpectedConditions.visibilityOfElementLocated(male));
		if(gender.equalsIgnoreCase("male")){
			if(!driver.findElement(male).isSelected()){
				driver.findElement(male).click();
			}
		}
		else {
			if(!driver.findElement(female).isSelected()){
				driver.findElement(female).click();
			}
		}
		
		//select yes/no whether you have experienced chest pain
		wait.until(ExpectedConditions.visibilityOfElementLocated(chestPainYes));
		if(doYouExperiencedchestPain.equalsIgnoreCase("yes")){
			if(!driver.findElement(chestPainYes).isSelected()){
				driver.findElement(chestPainYes).click();
			}
		}
		else {
			if(!driver.findElement(chestPainNo).isSelected()){
				driver.findElement(chestPainNo).click();
			}
		}
		
		// enter blood pressure level
		wait.until(ExpectedConditions.visibilityOfElementLocated(bloodPressureTextBox)).click();
		driver.findElement(bloodPressureTextBox).clear();
		driver.findElement(bloodPressureTextBox).sendKeys(bloodPressureLevel);
		
		// enter cholesterol level
		wait.until(ExpectedConditions.visibilityOfElementLocated(cholesterolLevelTextBox)).click();
		driver.findElement(cholesterolLevelTextBox).clear();
		driver.findElement(cholesterolLevelTextBox).sendKeys(cholesterolLevel);
		
		// enter fasting blood sugar level
		wait.until(ExpectedConditions.visibilityOfElementLocated(fastingBloodSugarLevelTextBox)).click();
		driver.findElement(fastingBloodSugarLevelTextBox).clear();
		driver.findElement(fastingBloodSugarLevelTextBox).sendKeys(fastingBloodSugarLevel);
		
		//Select RestECG positive/negative
		wait.until(ExpectedConditions.visibilityOfElementLocated(restECGPositive));
		if(restECG.equalsIgnoreCase("Positive")){
			if(!driver.findElement(restECGPositive).isSelected()){
				driver.findElement(restECGPositive).click();
			}
		}
		else {
			if(!driver.findElement(restECGNegative).isSelected()){
				driver.findElement(restECGNegative).click();
			}
		}
		
		// enter Maximum Heart Rate Achieved
		wait.until(ExpectedConditions.visibilityOfElementLocated(maximumHeartRateAchievedTextBox)).click();
		driver.findElement(maximumHeartRateAchievedTextBox).clear();
		driver.findElement(maximumHeartRateAchievedTextBox).sendKeys(maximumHeartRateAchieved);
		
		//Select Exercise Includes Angina Yes/No
		wait.until(ExpectedConditions.visibilityOfElementLocated(exerciseIncludesAnginaYes));
		if(exerciseIncludesAngina.equalsIgnoreCase("Yes")){
			if(!driver.findElement(exerciseIncludesAnginaYes).isSelected()){
					driver.findElement(exerciseIncludesAnginaYes).click();
				}
			}
			else {
				if(!driver.findElement(exerciseIncludesAnginaNo).isSelected()){
					driver.findElement(exerciseIncludesAnginaNo).click();
				}
			}
		
		// enter Depression Included By Exercise
		wait.until(ExpectedConditions.visibilityOfElementLocated(depressionIncludedByExerciseTextBox)).click();
		driver.findElement(depressionIncludedByExerciseTextBox).clear();
		driver.findElement(depressionIncludedByExerciseTextBox).sendKeys(depressionIncludedByExercise);
		
		// enter Slope Of The Peek Exercise
		wait.until(ExpectedConditions.visibilityOfElementLocated(slopeOfThePeekExerciseTextBox)).click();
		driver.findElement(slopeOfThePeekExerciseTextBox).clear();
		driver.findElement(slopeOfThePeekExerciseTextBox).sendKeys(slopeOfThePeekExercise);
		
		// enter Vessels Colored By Flouoroscopy
		wait.until(ExpectedConditions.visibilityOfElementLocated(vesselsColoredByFlouoroscopyTextBox)).click();
		driver.findElement(vesselsColoredByFlouoroscopyTextBox).clear();
		driver.findElement(vesselsColoredByFlouoroscopyTextBox).sendKeys(vesselsColoredByFlouoroscopy);
				
		// enter Thalassemia Level
		wait.until(ExpectedConditions.visibilityOfElementLocated(thalassemiaLevelTextBox)).click();
		driver.findElement(thalassemiaLevelTextBox).clear();
		driver.findElement(thalassemiaLevelTextBox).sendKeys(thalassemiaLevel);
		
		//Click on Calculate Button
		driver.findElement(calculateButton).click();
		
	}
}
