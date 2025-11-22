package com.rh.rh.facade;

import com.rh.rh.controllor.dto.RecruitmentDto;
import com.rh.rh.entity.Recruitment;
import com.rh.rh.repository.recruitment.RecruitmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class RecruitmentFacade {
    private final RecruitmentRepository recruitmentRepository;

    public RecruitmentFacade(RecruitmentRepository recruitmentRepository) {
        this.recruitmentRepository = recruitmentRepository;
    }

    public List<RecruitmentDto> recupererListeRecruitment(){
        return  recruitmentRepository.findAll()
                .stream()
                .map(RecruitmentDto::new)
                .sorted()
                .collect(toList());
    }

    public void enregistrerRecruitment(RecruitmentDto recruitmentDto){
        Recruitment recruitment = new Recruitment();
        recruitment.setNom(recruitmentDto.getNom());
        recruitment.setPrenoms(recruitmentDto.getPrenoms());
        recruitment.setEmail(recruitmentDto.getEmail());
        recruitment.setNumero(recruitmentDto.getNumero());

        recruitmentRepository.save(recruitment);
    }

    public void supprimerRecruitment(Long id)throws Exception{
        Optional<Recruitment> recruitmentOptional = recruitmentRepository.findById(id);
        if (recruitmentOptional.isPresent()) {
            recruitmentRepository.deleteById(id);
        }
        else {
            throw new Exception("Ce recruitment n'existe pas !");
        }
    }
}
