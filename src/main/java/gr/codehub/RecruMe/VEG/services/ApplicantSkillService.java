//package gr.codehub.RecruMe.VEG.services;
//
//import gr.codehub.RecruMe.VEG.dtos.SkillDto;
//import gr.codehub.RecruMe.VEG.models.Applicant;
//import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
//import gr.codehub.RecruMe.VEG.repositories.ApplicantSkills;
//import gr.codehub.RecruMe.VEG.repositories.Applicants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class ApplicantSkillService {
//    @Autowired
//    private ApplicantSkills applicantSkillsRepo;
//    @Autowired
//    private Applicants applicantRepo;
//
//    public ApplicantSkill createOrder(SkillDto skillDto) throws Exception {
//
//        if (skillDto == null) throw new Exception("order dto is null");
//        Applicant a = applicantRepo.findById(skillDto.getApplicantId()).get();
//        if (a == null) throw new Exception("applicant is not found");
//        if (skillDto.getDescription() == null)
//            throw new Exception("given product list is null");
//
//        ApplicantSkill o1 = new ApplicantSkill();
//
//        o1.setApplicant(a);
//        o1.setOrderdetails(new ArrayList<>());
//        applicantSkillsRepo.save(o1);
//        skillDto.getDescription().forEach(
//                productSkillDto -> {
//
//                    Orderdetail od = new Orderdetail(o1,
//                            productRepo.findById(productSkillDto.getProductId()).get(),
//                            productSkillDto.getPurchasedQuantity());
//
//                    productOrderRepo.save(od);
//                    o1.getOrderdetails().add(od);
//
//                });
//
//    }
