import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'memanggil test case login dengan valid user'
WebUI.callTestCase(findTestCase('Login/Login with valid user'), [:], FailureHandling.STOP_ON_FAILURE)

def listBarang = []

def listHargaClean = []

for (int i = 1; i <= 3; i++) {
    'memastikan label nama produk terlihat'
    WebUI.verifyElementVisible(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                    1, i)]))

    'get text nama barang'
    def barang = WebUI.getText(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                    1, i)]))

    'memastikan nama barang sudah sesuai dengan data tes yang diinginkan'
    WebUI.verifyMatch(barang, findTestData('Data Barang').getValue(1, i), false)

    'memastikan harga produk terlihat pada layar'
    WebUI.verifyElementVisible(findTestObject('Product Page/label_hargaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                    1, i)]))

    'get text harga product'
    def hargaBarang = WebUI.getText(findTestObject('Product Page/label_hargaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                    1, i)]))

    'menghilangkan tanda $ pada harga produk'
    def hargaClean = CustomKeywords.'pemrosesanHarga.cleansingHarga'(hargaBarang)

    'melakukan click pada button add to cart produk yang dipilih'
    WebUI.click(findTestObject('Product Page/button_addCartProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                    1, i)]))

    listBarang.add(barang)

    listHargaClean.add(hargaClean)
}

'memastikan label jumlah item yang dipilih terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Product Page/label_jumlahItemDipilih'))

'get text jumlah item yang dipilih'
def jumlahItem = WebUI.getText(findTestObject('Product Page/label_jumlahItemDipilih'))

'memastikan jumlah yang dipilih sudah sesuai'
WebUI.verifyMatch(listBarang.size().toString(), jumlahItem, false)

'mengambil screenshot'
WebUI.takeFullPageScreenshotAsCheckpoint('Berhasil Memilih Barang Loop')

'melakukan click pada cart / total item yang dipilih'
WebUI.click(findTestObject('Product Page/label_jumlahItemDipilih'))

'memastikan header your cart terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_headerYourCart'))

'get text header your cart'
def haderYourCart = WebUI.getText(findTestObject('Your Cart Page/label_headerYourCart'))

'memastikan label header your cart sudah sesuai'
WebUI.verifyMatch(haderYourCart, 'Your Cart', false)

for (int i = 1; i <= listBarang.size(); i++) {
    'memastikan nama item yang dipilih di halaman your cart terlihat'
    WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_namaItemCart', [('index') : i]))

    'get text nama item yang di pilih pada halaman your cart'
    def namaItemCart = WebUI.getText(findTestObject('Your Cart Page/label_namaItemCart', [('index') : i]))

    'memastikan label nama barang sudah sesuai dengan yang di pilih pada halaman produk'
    WebUI.verifyMatch(namaItemCart, listBarang[(i - 1)], false)

    'memastikan label harga produk terlihat pada layar'
    WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_hargaItemCart', [('index') : i]))

    'get text harga produk yang dipilih'
    def hargaItemCart = WebUI.getText(findTestObject('Your Cart Page/label_hargaItemCart', [('index') : i]))

    'memastikan label harga item sudah sesuai dengan yang dipilih pada halaman produk'
    WebUI.verifyMatch(hargaItemCart, listHargaClean[(i - 1)], false)
}

'memastikan button checkout dapat di click'
WebUI.verifyElementClickable(findTestObject('Your Cart Page/button_checkout'))

'mengambil screenshot pada layar your cart'
WebUI.takeFullPageScreenshotAsCheckpoint('Halaman Your Cart Loop')

'melakukan click pada button checkout'
WebUI.click(findTestObject('Your Cart Page/button_checkout'))

'memastikan header information checkout terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Information Checkout Page/label_headerInformationCheckout'))

'get text header information checkout'
def headerCheckoutInformation = WebUI.getText(findTestObject('Information Checkout Page/label_headerInformationCheckout'))

'memastikan label header information checkout sudah sesuai'
WebUI.verifyMatch(headerCheckoutInformation, 'Checkout: Your Information', false)

'memastikan textbox firstname terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Information Checkout Page/textbox_firstName'))

'input text pada textbox first name'
WebUI.setText(findTestObject('Information Checkout Page/textbox_firstName'), 'Mukhlis Anshori')

'memastikan textbox last name terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Information Checkout Page/textbox_lastName'))

'input pada textbox last name'
WebUI.setText(findTestObject('Information Checkout Page/textbox_lastName'), 'Witanto')

'memastikan textbox postal code terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Information Checkout Page/textbox_postalCode'))

'melakukan input pada textbox postal code'
WebUI.setText(findTestObject('Information Checkout Page/textbox_postalCode'), '65134')

'memastikan button continue dapat diclick'
WebUI.verifyElementClickable(findTestObject('Information Checkout Page/button_continue'), FailureHandling.STOP_ON_FAILURE)

'mengambil screenshot pada halaman informasi'
WebUI.takeFullPageScreenshotAsCheckpoint('Halaman Informasi Loop')

'melakukan click pada button continue'
WebUI.click(findTestObject('Information Checkout Page/button_continue'), FailureHandling.STOP_ON_FAILURE)

'memastikan header checkout review terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_headerCheckoutOverview'), FailureHandling.STOP_ON_FAILURE)

'get text pada header checkout overview'
def headerOverview = WebUI.getText(findTestObject('Checkout Overview Page/label_headerCheckoutOverview'), FailureHandling.STOP_ON_FAILURE)

'memastikan label header sudah sesuai'
WebUI.verifyMatch(headerOverview, 'Checkout: Overview', false)

for (int i = 1; i <= listBarang.size(); i++) {
    'memastikan label nama barang pada halaman checkout overview terlihat pada layar'
    WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_namaBarangOverview', [('index') : i]))

    'get text nama produk pada halaman checkout overview'
    def namaBarangOverview = WebUI.getText(findTestObject('Checkout Overview Page/label_namaBarangOverview', [('index') : i]))

    'memastikan labael nama barang sudah sesuai dengan yang dipilih'
    WebUI.verifyMatch(namaBarangOverview, listBarang[(i - 1)], false)

    'memastikan label harga barang terlihat'
    WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_hargaBarangOverview', [('index') : i]))

    'get text label harga barang'
    def hargaBarangOverview = WebUI.getText(findTestObject('Checkout Overview Page/label_hargaBarangOverview', [('index') : i]))

    'melakukan cleansing harga barang'
    def hargaBarangOverviewClean = CustomKeywords.'pemrosesanHarga.cleansingHarga'(hargaBarangOverview)

    'memastikan harga barang sudah sesuai dengan yang di pilih'
    WebUI.verifyMatch(hargaBarangOverviewClean, listHargaClean[(i - 1)], false)
}

def totalHargaPerhitungan = CustomKeywords.'pemrosesanHarga.perhitunganItemTotalLoop'(listHargaClean[0], listHargaClean[
    1], listHargaClean[2])

'memastikan label harga item total terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_itemTotal'))

'get text harga item total'
def totalHarga = WebUI.getText(findTestObject('Checkout Overview Page/label_itemTotal'))

'melakukan cleansing harga (menghilangkan tanda $)'
def totalHargaClean = totalHarga.replace('Item total: $', '')

'memastikan harga sudah sesuai penjumlahan'
WebUI.verifyMatch(totalHargaClean, totalHargaPerhitungan, false)

'melakukan perhitungan tax total items'
def perhitunganTax = CustomKeywords.'pemrosesanHarga.perhitunganTax'(totalHargaClean)

'memastikan label tax total terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_taxHarga'))

'get text total tax'
def taxBarang = WebUI.getText(findTestObject('Checkout Overview Page/label_taxHarga'))

'melakukan cleansing label text total tax'
def taxTotal = taxBarang.replace('Tax: $', '')

'memastikan tax sudah sesuai dengan perhitungan'
WebUI.verifyMatch(taxTotal, perhitunganTax, false)

'memastikan label total keseluruhan terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_totalHargaBarang'))

'get text total harga keseluruhan'
def totalHargaAllItem = WebUI.getText(findTestObject('Checkout Overview Page/label_totalHargaBarang'))

'melakukan cleansing total harga keseluruhan'
def totalBarangClean = totalHargaAllItem.replace('Total: $', '')

'melakukan perhitungan total harga keseluruhan'
def perhitunganTotall = CustomKeywords.'pemrosesanHarga.perhitunganTotal'(totalHargaPerhitungan, perhitunganTax)

'memastikan total harga keseluruhan sudah sesuai dengan perhitungan'
WebUI.verifyMatch(totalBarangClean, perhitunganTotall, false)

'memastikan button finish dapat diclick'
WebUI.verifyElementClickable(findTestObject('Checkout Overview Page/button_finish'))

'mengambil screenshot overview items'
WebUI.takeFullPageScreenshotAsCheckpoint('Overview Items Loop')

'melakukan click pada button finish'
WebUI.click(findTestObject('Checkout Overview Page/button_finish'))

'memastikan label header finish terlihat'
WebUI.verifyElementVisible(findTestObject('Finish Page/label_headerFinish'))

'get text label header finish'
def headerFinish = WebUI.getText(findTestObject('Finish Page/label_headerFinish'))

'memastikan label text sesuai'
WebUI.verifyMatch(headerFinish, 'Finish', false)

'memastikan label thank you fo order terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Finish Page/label_thankYouOrder'))

'get text label thankyou for order'
def greetingForOrder = WebUI.getText(findTestObject('Finish Page/label_thankYouOrder'))

'memastikan label text sesuai'
WebUI.verifyMatch(greetingForOrder, 'THANK YOU FOR YOUR ORDER', false)

'mengambil screenshot berhasil order'
WebUI.takeFullPageScreenshotAsCheckpoint('Berhasil Order Loop')

