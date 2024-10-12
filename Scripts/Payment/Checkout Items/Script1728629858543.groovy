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

'memastikan label nama produk pertama yang akan di pilih terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 1)]))

'get text nama barang pertama yang akan di pilih'
def barang1 = WebUI.getText(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 1)]))

'memastikan nama barang sudah sesuai dengan data tes di excel pada kolom ke 1 baris ke 1'
WebUI.verifyMatch(barang1, findTestData('Data Barang').getValue(1, 1), false)

'memastikan harga produk barang pertama dipilih terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Product Page/label_hargaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 1)]))

'get text harga product pertama yang dipilih'
def hargaBarang1 = WebUI.getText(findTestObject('Product Page/label_hargaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 1)]))

'menghilangkan tanda $ pada harga produk'
def hargaClean1 = CustomKeywords.'pemrosesanHarga.cleansingHarga'(hargaBarang1)

'melakukan click pada button add to cart produk pertama yang dipilih'
WebUI.click(findTestObject('Product Page/button_addCartProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 1)]))

//batas
'memastikan label nama produk kedua yang dipilih terlihat'
WebUI.verifyElementVisible(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 2)]))

'get text nama barang kedua yang dipilih'
def barang2 = WebUI.getText(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 2)]))

'memastikan nama barang sudah sesuai dengan data tes pada excel di kolom ke 1 baris ke 2'
WebUI.verifyMatch(barang2, findTestData('Data Barang').getValue(1, 2), false)

'memastikan harga produk kedua yang di pilih terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 2)]))

'get text harga product kedua'
def hargaBarang2 = WebUI.getText(findTestObject('Product Page/label_hargaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 2)]))

'menghilangkan tanda $ pada harga produk'
def hargaClean2 = CustomKeywords.'pemrosesanHarga.cleansingHarga'(hargaBarang2)

'melakukan click pada button add to cart produk kedua yang dipilih'
WebUI.click(findTestObject('Product Page/button_addCartProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 2)]))

//batas
'memastikan label nama produk ketiga terlihat'
WebUI.verifyElementVisible(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 3)]))

'get text nama barang ketiga'
def barang3 = WebUI.getText(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 3)]))

'memastikan nama barang sudah sesuai dengan data tes excel pada kolom ke 1 baris ke 3'
WebUI.verifyMatch(barang3, findTestData('Data Barang').getValue(1, 3), false)

'memastikan harga produk ketiga terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 3)]))

'get text harga product ketiga'
def hargaBarang3 = WebUI.getText(findTestObject('Product Page/label_hargaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 3)]))

'menghilangkan tanda $ pada harga produk'
def hargaClean3 = CustomKeywords.'pemrosesanHarga.cleansingHarga'(hargaBarang3)

'melakukan click pada button add to cart produk ketiga yang dipilih'
WebUI.click(findTestObject('Product Page/button_addCartProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 3)]))

//batas
'memastikan label nama produk ke empat terlihat'
WebUI.verifyElementVisible(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 4)]))

'get text nama barang ke empat'
def barang4 = WebUI.getText(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 4)]))

'memastikan nama barang sudah sesuai dengan data tes excel pada kolom ke 1 baris ke 4'
WebUI.verifyMatch(barang4, findTestData('Data Barang').getValue(1, 4), false)

'memastikan harga produk ke empat terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Product Page/label_namaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 4)]))

'get text harga product ke empat'
def hargaBarang4 = WebUI.getText(findTestObject('Product Page/label_hargaProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 4)]))

'menghilangkan tanda $ pada harga produk'
def hargaClean4 = CustomKeywords.'pemrosesanHarga.cleansingHarga'(hargaBarang4)

'melakukan click pada button add to cart produk yang dipilih'
WebUI.click(findTestObject('Product Page/button_addCartProduct', [('namaBarang') : findTestData('Data Barang').getValue(
                1, 4)]))

'memastikan label jumlah item yang dipilih pada logo shop pojok kanan atas terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Product Page/label_jumlahItemDipilih'))

'get text jumlah item yang dipilih'
def jumlahItem = WebUI.getText(findTestObject('Product Page/label_jumlahItemDipilih'))

'memastikan jumlah yang dipilih sudah sesuai'
WebUI.verifyMatch('4', jumlahItem, false)

'mengambil screenshot berhasil memilih barang'
WebUI.takeFullPageScreenshotAsCheckpoint('Berhasil Memilih Barang')

'melakukan click pada cart / total item yang dipilih'
WebUI.click(findTestObject('Product Page/label_jumlahItemDipilih'))

'memastikan header your cart terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_headerYourCart'))

'get text header your cart'
def haderYourCart = WebUI.getText(findTestObject('Your Cart Page/label_headerYourCart'))

'memastikan label header your cart sudah sesuai dengan expected'
WebUI.verifyMatch(haderYourCart, 'Your Cart', false)

//batas
'memastikan nama item pertama yang dipilih di halaman your cart terlihat'
WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_namaItemCart', [('index') : 1]))

'get text nama item pertama yang di pilih pada halaman your cart'
def namaItemCart1 = WebUI.getText(findTestObject('Your Cart Page/label_namaItemCart', [('index') : 1]))

'memastikan label nama barang pertama sudah sesuai dengan yang di pilih pada halaman produk'
WebUI.verifyMatch(namaItemCart1, barang1, false)

'memastikan label harga produk pertama terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_hargaItemCart', [('index') : 1]))

'get text harga produk pertama yang dipilih'
def hargaItemCart1 = WebUI.getText(findTestObject('Your Cart Page/label_hargaItemCart', [('index') : 1]))

'memastikan label harga item product pertama sudah sesuai dengan yang dipilih pada halaman produk'
WebUI.verifyMatch(hargaItemCart1, hargaClean1, false)

//batas
'memastikan nama item ke dua yang dipilih di halaman your cart terlihat'
WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_namaItemCart', [('index') : 2]))

'get text nama item kedua yang di pilih pada halaman your cart'
def namaItemCart2 = WebUI.getText(findTestObject('Your Cart Page/label_namaItemCart', [('index') : 2]))

'memastikan label nama barang kedua sudah sesuai dengan yang di pilih pada halaman produk'
WebUI.verifyMatch(namaItemCart2, barang2, false)

'memastikan label harga produk kedua terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_hargaItemCart', [('index') : 2]))

'get text harga produk yang dipilih'
def hargaItemCart2 = WebUI.getText(findTestObject('Your Cart Page/label_hargaItemCart', [('index') : 2]))

'memastikan label harga item kedua sudah sesuai dengan yang dipilih pada halaman produk'
WebUI.verifyMatch(hargaItemCart2, hargaClean2, false)

//batas
'memastikan nama item produk ketiga yang dipilih di halaman your cart terlihat'
WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_namaItemCart', [('index') : 3]))

'get text nama item ketiga yang di pilih pada halaman your cart'
def namaItemCart3 = WebUI.getText(findTestObject('Your Cart Page/label_namaItemCart', [('index') : 3]))

'memastikan label nama barang ketiga sudah sesuai dengan yang di pilih pada halaman produk'
WebUI.verifyMatch(namaItemCart3, barang3, false)

'memastikan label harga produk ketiga terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_hargaItemCart', [('index') : 3]))

'get text harga produk ketiga yang dipilih'
def hargaItemCart3 = WebUI.getText(findTestObject('Your Cart Page/label_hargaItemCart', [('index') : 3]))

'memastikan label harga item ketiga sudah sesuai dengan yang dipilih pada halaman produk'
WebUI.verifyMatch(hargaItemCart3, hargaClean3, false)

//batas
'memastikan nama item keempat yang dipilih di halaman your cart terlihat'
WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_namaItemCart', [('index') : 4]))

'get text nama item keempat yang di pilih pada halaman your cart'
def namaItemCart4 = WebUI.getText(findTestObject('Your Cart Page/label_namaItemCart', [('index') : 4]))

'memastikan label nama barang keempat sudah sesuai dengan yang di pilih pada halaman produk'
WebUI.verifyMatch(namaItemCart4, barang4, false)

'memastikan label harga produk keempat terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Your Cart Page/label_hargaItemCart', [('index') : 4]))

'get text harga produk keempat yang dipilih'
def hargaItemCart4 = WebUI.getText(findTestObject('Your Cart Page/label_hargaItemCart', [('index') : 4]))

'memastikan label harga item keempat sudah sesuai dengan yang dipilih pada halaman produk'
WebUI.verifyMatch(hargaItemCart4, hargaClean4, false)

'memastikan button checkout dapat di click'
WebUI.verifyElementClickable(findTestObject('Your Cart Page/button_checkout'))

'mengambil screenshot pada layar your cart'
WebUI.takeFullPageScreenshotAsCheckpoint('Halaman Your Cart')

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

'input text pada textbox first name dengan value Mukhlis Anshori'
WebUI.setText(findTestObject('Information Checkout Page/textbox_firstName'), 'Mukhlis Anshori')

'memastikan textbox last name terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Information Checkout Page/textbox_lastName'))

'input pada textbox last name dengan value Witanto'
WebUI.setText(findTestObject('Information Checkout Page/textbox_lastName'), 'Witanto')

'memastikan textbox postal code terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Information Checkout Page/textbox_postalCode'))

'melakukan input pada textbox postal code dengan value 65134'
WebUI.setText(findTestObject('Information Checkout Page/textbox_postalCode'), '65134')

'memastikan button continue dapat diclick'
WebUI.verifyElementClickable(findTestObject('Information Checkout Page/button_continue'), FailureHandling.STOP_ON_FAILURE)

'mengambil screenshot pada halaman informasi'
WebUI.takeFullPageScreenshotAsCheckpoint('Halaman Informasi')

'melakukan click pada button continue'
WebUI.click(findTestObject('Information Checkout Page/button_continue'), FailureHandling.STOP_ON_FAILURE)

'memastikan header checkout review terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_headerCheckoutOverview'), FailureHandling.STOP_ON_FAILURE)

'get text pada header checkout overview'
def headerOverview = WebUI.getText(findTestObject('Checkout Overview Page/label_headerCheckoutOverview'), FailureHandling.STOP_ON_FAILURE)

'memastikan label header sudah sesuai'
WebUI.verifyMatch(headerOverview, 'Checkout: Overview', false)

//batas
'memastikan label nama barang pertama pada halaman checkout overview terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_namaBarangOverview', [('index') : 1]))

'get text nama produk pertama pada halaman checkout overview'
def namaBarangOverview1 = WebUI.getText(findTestObject('Checkout Overview Page/label_namaBarangOverview', [('index') : 1]))

'memastikan label nama barang pertama sudah sesuai dengan yang dipilih'
WebUI.verifyMatch(namaBarangOverview1, barang1, false)

'memastikan label harga barang pertama terlihat'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_hargaBarangOverview', [('index') : 1]))

'get text label harga barang pertama'
def hargaBarangOverview1 = WebUI.getText(findTestObject('Checkout Overview Page/label_hargaBarangOverview', [('index') : 1]))

'melakukan cleansing harga barang pertama untuk get hanya value harga saja'
def hargaBarangOverviewClean1 = CustomKeywords.'pemrosesanHarga.cleansingHarga'(hargaBarangOverview1)

'memastikan harga barang pertama sudah sesuai dengan yang di pilih'
WebUI.verifyMatch(hargaBarangOverviewClean1, hargaClean1, false)

//batas
'memastikan label nama barang kedua pada halaman checkout overview terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_namaBarangOverview', [('index') : 2]))

'get text nama produk kedua pada halaman checkout overview'
def namaBarangOverview2 = WebUI.getText(findTestObject('Checkout Overview Page/label_namaBarangOverview', [('index') : 2]))

'memastikan label nama barang kedua sudah sesuai dengan yang dipilih'
WebUI.verifyMatch(namaBarangOverview2, barang2, false)

'memastikan label harga barang kedua terlihat'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_hargaBarangOverview', [('index') : 2]))

'get text label harga barang kedua'
def hargaBarangOverview2 = WebUI.getText(findTestObject('Checkout Overview Page/label_hargaBarangOverview', [('index') : 2]))

'melakukan cleansing harga barang kedua untuk get value nominal harga saja'
def hargaBarangOverviewClean2 = CustomKeywords.'pemrosesanHarga.cleansingHarga'(hargaBarangOverview2)

'memastikan harga barang kedua sudah sesuai dengan yang di pilih'
WebUI.verifyMatch(hargaBarangOverviewClean2, hargaClean2, false)

//batas
'memastikan label nama barang ketiga pada halaman checkout overview terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_namaBarangOverview', [('index') : 3]))

'get text nama produk ketiga pada halaman checkout overview'
def namaBarangOverview3 = WebUI.getText(findTestObject('Checkout Overview Page/label_namaBarangOverview', [('index') : 3]))

'memastikan label nama barang ketiga sudah sesuai dengan yang dipilih'
WebUI.verifyMatch(namaBarangOverview3, barang3, false)

'memastikan label harga barang ketiga terlihat'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_hargaBarangOverview', [('index') : 3]))

'get text label harga barang ketiga'
def hargaBarangOverview3 = WebUI.getText(findTestObject('Checkout Overview Page/label_hargaBarangOverview', [('index') : 3]))

'melakukan cleansing harga barang ketiga untuk get value nominal harga'
def hargaBarangOverviewClean3 = CustomKeywords.'pemrosesanHarga.cleansingHarga'(hargaBarangOverview3)

'memastikan harga barang ketiga sudah sesuai dengan yang di pilih'
WebUI.verifyMatch(hargaBarangOverviewClean3, hargaClean3, false)

//batas
'memastikan label nama barang keempat pada halaman checkout overview terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_namaBarangOverview', [('index') : 4]))

'get text nama produk keempat pada halaman checkout overview'
def namaBarangOverview4 = WebUI.getText(findTestObject('Checkout Overview Page/label_namaBarangOverview', [('index') : 4]))

'memastikan label nama barang keempat sudah sesuai dengan yang dipilih'
WebUI.verifyMatch(namaBarangOverview4, barang4, false)

'memastikan label harga barang keempat terlihat'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_hargaBarangOverview', [('index') : 4]))

'get text label harga barang keempat'
def hargaBarangOverview4 = WebUI.getText(findTestObject('Checkout Overview Page/label_hargaBarangOverview', [('index') : 4]))

'melakukan cleansing harga barang keempat untuk get value nominal harga'
def hargaBarangOverviewClean4 = CustomKeywords.'pemrosesanHarga.cleansingHarga'(hargaBarangOverview4)

'memastikan harga barang keempat sudah sesuai dengan yang di pilih'
WebUI.verifyMatch(hargaBarangOverviewClean4, hargaClean4, false)

'melakukan perhitungan harga item pada custom keyword'
def totalHargaPerhitungan = CustomKeywords.'pemrosesanHarga.perhitunganItemTotal'(hargaBarangOverviewClean1, hargaBarangOverviewClean2, 
    hargaBarangOverviewClean3, hargaBarangOverviewClean4)

'memastikan label harga item total terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Checkout Overview Page/label_itemTotal'))

'get text harga item total'
def totalHarga = WebUI.getText(findTestObject('Checkout Overview Page/label_itemTotal'))

'melakukan cleansing harga (menghilangkan tanda $)'
def totalHargaClean = totalHarga.replace('Item total: $', '')

'memastikan harga sudah sesuai penjumlahan'
WebUI.verifyMatch(totalHargaClean, totalHargaPerhitungan, false)

'melakukan perhitungan tax total items dengan custom keyword'
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
WebUI.takeFullPageScreenshotAsCheckpoint('Overview Items')

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
WebUI.takeFullPageScreenshotAsCheckpoint('Berhasil Order')

