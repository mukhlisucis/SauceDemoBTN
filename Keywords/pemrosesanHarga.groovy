import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class pemrosesanHarga {

	@Keyword
	def cleansingHarga(String hargaBarang) {
		def hargaBarangClean = hargaBarang.replace('$','')
		return hargaBarangClean
	}

	@Keyword
	def perhitunganItemTotal(String hargaBarang1, String hargaBarang2, String hargaBarang3,String hargaBarang4) {
		def harga1 = hargaBarang1.toBigDecimal();
		def harga2 = hargaBarang2.toBigDecimal();
		def harga3 = hargaBarang3.toBigDecimal();
		def harga4 = hargaBarang4.toBigDecimal();
		def total = harga1+harga2+harga3+harga4
		def totalToString = total.toString()
		return totalToString
	}

	@Keyword
	def perhitunganTotal(String itemTotal , String taxTotal) {
		def totalHarga= (itemTotal.toBigDecimal()+taxTotal.toBigDecimal())
		def totalHargaToString=totalHarga.toString()
		return totalHargaToString
	}

	@Keyword
	def perhitunganTax(String totalHarga) {
		def tax = ((8/100)*totalHarga.toBigDecimal())
		def taxRounded = new BigDecimal(tax).setScale(2, BigDecimal.ROUND_HALF_UP)
		def taxToString = taxRounded.toString()
		return taxToString
	}
	
	@Keyword
	def perhitunganItemTotalLoop(String hargaBarang1, String hargaBarang2, String hargaBarang3) {
		def harga1 = hargaBarang1.toBigDecimal();
		def harga2 = hargaBarang2.toBigDecimal();
		def harga3 = hargaBarang3.toBigDecimal();
		def total = harga1+harga2+harga3
		def totalToString = total.toString()
		return totalToString
	}
}
