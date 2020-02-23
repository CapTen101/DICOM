/* 
 * Insert your own name package name here 
 * 
 */
package tushar;

/* 
 * pixelmed library are used here for the purpose.
 * @link http://www.pixelmed.com/dicomtoolkit.html
 * 
 */

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.display.SourceImage;

/* 
 * Insert your own class here
 * 
 */

public class DICOM2 {

	private static AttributeList list = new AttributeList();

	public static void main(String[] args) {

/*
* Insert your own path of DICOM file For testing purpose: @link
* http://www.rubomedical.com/dicom_files/
* 
*/

		String dicomFile = "D:\\DELL\\Softwares\\0002.DCM";

		try {
			list.read(dicomFile);
      
/*
* Reading the metadata
* check the ouput metadata in output.java
*/

			System.out.println("Patient Name:" + getTagInformation(TagFromName.PatientName));
			System.out.println("Patient ID:" + getTagInformation(TagFromName.PatientID));
			System.out.println("Transfer Syntax:" + getTagInformation(TagFromName.TransferSyntaxUID));
			System.out.println("SOP Class:" + getTagInformation(TagFromName.SOPClassUID));
			System.out.println("Modality:" + getTagInformation(TagFromName.Modality));
			System.out.println("Samples Per Pixel:" + getTagInformation(TagFromName.SamplesPerPixel));
			System.out.println("Photometric Interpretation:" + getTagInformation(TagFromName.PhotometricInterpretation));
			System.out.println("Pixel Spacing:" + getTagInformation(TagFromName.PixelSpacing));
			System.out.println("Bits Allocated:" + getTagInformation(TagFromName.BitsAllocated));
			System.out.println("Bits Stored:" + getTagInformation(TagFromName.BitsStored));
			System.out.println("High Bit:" + getTagInformation(TagFromName.HighBit));
			SourceImage img = new com.pixelmed.display.SourceImage(list);
			System.out.println("Number of frames " + img.getNumberOfFrames());
			System.out.println("Width " + img.getWidth());// all frames will have same width
			System.out.println("Height " + img.getHeight());// all frames will have same height
			System.out.println("Is Grayscale? " + img.isGrayscale());
			System.out.println("Pixel Data present:" + (list.get(TagFromName.PixelData) != null));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getTagInformation(AttributeTag attrTag) {
		return Attribute.getDelimitedStringValuesOrEmptyString(list, attrTag);
	}
}
